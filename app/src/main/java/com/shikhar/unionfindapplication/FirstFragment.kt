package com.shikhar.unionfindapplication

import android.os.Bundle
import android.view.*
import android.widget.AdapterView
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.view.isInvisible
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.shikhar.unionfindapplication.databinding.ActivityMainBinding.inflate
import com.shikhar.unionfindapplication.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null
   // var edttxtfirstnode:EditText
    lateinit var edttxtsecondnode:EditText
    lateinit var seeconnect: Button
    lateinit var txtviewFirstFragment:TextView
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

         //seeconnect.isInvisible
        _binding = FragmentFirstBinding.inflate(inflater, container, false)


        binding.edttxtfirstnode.doOnTextChanged { text, start, _, _ ->
            if (text!!.length > 2){
                binding.edttxtfirstnode.error = "Enter Number from 1 to 20"
            }else if (text!!.length <2 && start < 0){
                binding.edttxtfirstnode.error = null
            }
        }
        binding.edttxtsecondnode.doOnTextChanged { text, start, _, _ ->
            if (text!!.length > 2){
                binding.edttxtsecondnode.error = "Enter Number from 1 to 20"
            }else if (text!!.length <2 && start < 0){
                binding.edttxtsecondnode.error = null
            }
        }
        return binding.root

    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
           /* R.id.action_settings -> true*/
            R.id.addconnections->
                true
            else -> super.onOptionsItemSelected(item)

        }
    }

//UnionFindAlgorithm




    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)

        binding.seeconnect.setOnClickListener {


            val firstnodeinput: Int = binding.edttxtfirstnode.text.toString().toInt()!!
            val secondnodeinput: Int = binding.edttxtsecondnode.text.toString().toInt()!!
            val connected: Boolean? = MainActivity().d.connected(firstnodeinput,secondnodeinput)

            if(connected == true){
                val ans:String="(" + firstnodeinput +" , "+ secondnodeinput + ")" + "are connected"
                binding.txtviewFirstFragment.setText(ans).toString()
                binding.seeconnect.visibility = View.INVISIBLE
            }else{
                val ans:String="(" + firstnodeinput +" , "+ secondnodeinput + ")" + "are not connected"
                binding.txtviewFirstFragment.setText(ans).toString()
                binding.seeconnect.visibility = View.INVISIBLE
            }
            try {


            }catch (_:java.lang.RuntimeException){
                findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
            }




           // findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }

    }
    private fun check(firstnodeinput: Int, secondnodeinput: Int): Boolean? {
        val ans:String="(" + firstnodeinput +" + "+ secondnodeinput + ")" + "are connected"
        return MainActivity().d.connected(firstnodeinput,secondnodeinput)
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}