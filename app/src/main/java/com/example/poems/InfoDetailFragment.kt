package com.example.poems

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.PopupMenu
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

class InfoDetailFragment : Fragment() {

    companion object {
        private const val ARG_INFO = "arg_info"

        fun newInstance(info: Info): InfoDetailFragment {
            val fragment = InfoDetailFragment()
            val args = Bundle()
            args.putParcelable(ARG_INFO, info)
            fragment.arguments = args
            return fragment
        }
    }

    private lateinit var info: Info

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            info = it.getParcelable(ARG_INFO)!!
        }
        setHasOptionsMenu(true)
    }

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        (requireActivity() as AppCompatActivity).supportActionBar?.hide()

        val view = inflater.inflate(R.layout.info_details_fragment, container, false)
        val titleTextView: TextView = view.findViewById(R.id.titleTextView)
        val descriptionTextView: TextView = view.findViewById(R.id.descriptionTextView)
      //  val btnBack: ImageView = view.findViewById(R.id.btnBack)
        val btnMenu: ImageView = view.findViewById(R.id.btnMenu)

        titleTextView.text = info.title
        descriptionTextView.text = info.description

     /*   btnBack.setOnClickListener {
            parentFragmentManager.popBackStack()
        }*/

        btnMenu.setOnClickListener {
            showPopupMenu(btnMenu)
        }

        return view
    }
    private fun showPopupMenu(anchorView: View) {
        val popupMenu = PopupMenu(requireContext(), anchorView)
        popupMenu.inflate(R.menu.text_size_menu)

        popupMenu.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.small_text -> {
                    changeTextSize(14)
                    true
                }
                R.id.medium_text -> {
                    changeTextSize(18)
                    true
                }
                R.id.large_text -> {
                    changeTextSize(25)
                    true
                }
                else -> false
            }
        }

        popupMenu.show()
    }

    private fun changeTextSize(size: Int) {
        /*titleTextView.textSize = size.toFloat()
        descriptionTextView.textSize = size.toFloat()*/
        val titleTextView: TextView? = view?.findViewById(R.id.titleTextView)
        val descriptionTextView: TextView? = view?.findViewById(R.id.descriptionTextView)

        if (titleTextView != null) {
            titleTextView.textSize = size.toFloat()
        }
        if (descriptionTextView != null) {
            descriptionTextView.textSize = size.toFloat()
        }
    }

    override fun onStop() {
        super.onStop()
        parentFragmentManager.popBackStack()
    }
}

