package nks.infotech.roomdatabase.fragment.list

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import nks.infotech.roomdatabase.R

class ListFragment : Fragment() {
    lateinit var button: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view=inflater.inflate(R.layout.fragment_list, container, false)
        button=view.findViewById(R.id.floatingActionButton)
        val navController=findNavController()

        button.setOnClickListener {
            Log.d("test","Floating Button Clicked")
            navController.navigate(R.id.action_listFragment_to_addFragment)
        }
        return view
    }


}