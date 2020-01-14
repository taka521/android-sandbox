package com.example.fragmentsample


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ListAdapter
import android.widget.ListView
import android.widget.SimpleAdapter

/**
 * A simple [Fragment] subclass.
 */
class MenuListFragment : Fragment() {

    /**
     * 大画面判定用フラグ
     */
    private var _isLayoutXlarge = true

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val menuThanksFrame = activity?.findViewById<View>(R.id.menuThanksFrame)
        if (menuThanksFrame == null) {
            _isLayoutXlarge = false
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_menu_list, container, false)
        val lvMenu = view.findViewById<ListView>(R.id.lvMenu)

        val menuList: MutableList<MutableMap<String, String>> = mutableListOf()

        var menu = mutableMapOf("name" to "ハンバーグ", "price" to "800円")
        menuList.add(menu)

        menu = mutableMapOf("name" to "ハンバーグ定食", "price" to "850円")
        menuList.add(menu)

        val from = arrayOf("name", "price")
        val to = intArrayOf(android.R.id.text1, android.R.id.text2)

        val adapter = SimpleAdapter(activity, menuList, android.R.layout.simple_expandable_list_item_2, from, to)
        lvMenu.adapter = adapter
        lvMenu.onItemClickListener = ListItemClickListener()

        return view
    }

    private inner class ListItemClickListener : AdapterView.OnItemClickListener {
        override fun onItemClick(parent: AdapterView<*>, view: View, position: Int, id: Long) {

            val item = parent.getItemAtPosition(position) as MutableMap<String, String>

            val menuName = item["name"]
            val menuPrice = item["price"]

            val bundle = Bundle().apply {
                putString("menuName", menuName)
                putString("menuPrice", menuPrice)
            }

            if (_isLayoutXlarge) {
                val transaction = fragmentManager?.beginTransaction()
                val menuThanksFragment = MenuThanksFragment()
                menuThanksFragment.arguments = bundle
                transaction?.replace(R.id.menuThanksFrame, menuThanksFragment)
                transaction?.commit()
            } else {
                val intent = Intent(activity, MenuThanksActivity::class.java)
                intent.putExtras(bundle)
                startActivity(intent)
            }


        }

    }

}
