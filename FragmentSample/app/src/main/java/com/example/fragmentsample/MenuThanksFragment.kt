package com.example.fragmentsample


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView

/**
 * A simple [Fragment] subclass.
 */
class MenuThanksFragment : Fragment() {

    /** 大画面判定用フラグ */
    private var _isLayoutXLarge = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val menuListFragment = fragmentManager?.findFragmentById(R.id.fragmentMenuList)
        if (menuListFragment == null) {
            _isLayoutXLarge = false
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_menu_thanks, container, false)

        val extras: Bundle?
        extras = if (_isLayoutXLarge) {
            arguments
        } else {
            val intent = activity?.intent
            intent?.extras
        }

        val menuName = extras?.getString("menuName")
        val menuPrice = extras?.getString("menuPrice")

        val tvMenuName = view.findViewById<TextView>(R.id.tvMenuName)
        val tvMenuPrice = view.findViewById<TextView>(R.id.tvMenuPrice)
        tvMenuName.text = menuName
        tvMenuPrice.text = menuPrice

        val btBackButton = view.findViewById<Button>(R.id.btBackButton)
        btBackButton.setOnClickListener(ButtonClickListener())

        return view
    }

    private inner class ButtonClickListener : View.OnClickListener {
        override fun onClick(v: View?) {
            if (_isLayoutXLarge) {
                fragmentManager?.beginTransaction()?.let {
                    it.remove(this@MenuThanksFragment)
                    it.commit()
                }
            } else {
                activity?.finish()
            }
        }
    }


}
