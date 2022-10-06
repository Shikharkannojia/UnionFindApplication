package com.shikhar.unionfindapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doOnTextChanged
import androidx.navigation.fragment.findNavController
import com.shikhar.unionfindapplication.databinding.FragmentSecondBinding

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)

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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.addconnect.setOnClickListener {
            val firstnodeinput: Int = binding.edttxtfirstnode.text.toString().toInt()
            val secondnodeinput: Int= binding.edttxtsecondnode.text.toString().toInt()

            val connection:Boolean? = MainActivity().d.union(firstnodeinput,secondnodeinput)
            if(connection == true){
                val ans:String="(" + firstnodeinput +" , "+ secondnodeinput + ")" + "are connected"
                binding.txtviewSecondFragment.setText(ans).toString()
                binding.addconnect.visibility = View.INVISIBLE
            }else{
                val ans:String="(" + firstnodeinput +" , "+ secondnodeinput + ")" + "are already connected"
                binding.txtviewSecondFragment.setText(ans).toString()
                binding.addconnect.visibility = View.INVISIBLE
            }
            try {


            }catch (_:RuntimeException){
                findNavController().navigate(R.id.action_SecondFragment_to_FirstFragment)
            }
        }
    }
    private fun union(firstnodeinput: Int, secondnodeinput: Int): Boolean? {
        val ans:String="(" + firstnodeinput +" + "+ secondnodeinput + ")" + "are connected"
        return MainActivity().d.union(firstnodeinput,secondnodeinput)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}