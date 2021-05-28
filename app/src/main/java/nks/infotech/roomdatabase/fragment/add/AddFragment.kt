package nks.infotech.roomdatabase.fragment.add

import android.icu.number.IntegerWidth
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.fragment_add.*
import kotlinx.android.synthetic.main.fragment_add.view.*
import kotlinx.android.synthetic.main.fragment_list.view.*
import nks.infotech.roomdatabase.R
import nks.infotech.roomdatabase.data.User
import nks.infotech.roomdatabase.data.UserViewModel
import java.lang.Integer.parseInt

class AddFragment : Fragment() {

    lateinit var mViewModel:UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view=inflater.inflate(R.layout.fragment_add, container, false)
        mViewModel=ViewModelProvider(this).get(UserViewModel::class.java)
        view.addButton.setOnClickListener{
            insertDataToDatabase()
        }

        return view
    }

    private fun insertDataToDatabase() {
        val firstName=FirstName.text.toString()
        val lastName=LastName.text.toString()
        val age=age.text.toString()

        if(inputCheck(firstName,lastName, age)){
            //User Obj
            val user=User(0,firstName,lastName,Integer.parseInt(age.toString()))

            //Add to Database
            mViewModel.addUser(user)
            Toast.makeText(requireContext(),"Added",Toast.LENGTH_LONG).show()

            //Navigate Back
            findNavController().navigate(R.id.action_addFragment_to_listFragment)
        }
        else{
            Toast.makeText(requireContext(),"Fill All Field",Toast.LENGTH_LONG).show()

        }
    }

    private fun inputCheck(firstName:String,lastName:String,age:String):Boolean{
        return !(TextUtils.isEmpty(firstName) && TextUtils.isEmpty(lastName) && TextUtils.isEmpty(age))
    }

}