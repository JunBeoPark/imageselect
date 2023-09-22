package com.android.selectimage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils.replace
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.android.selectimage.ActivityMainBinding
import com.android.selectimage.BookmarkFragment
import com.android.selectimage.SearchFragment
import com.android.selectimage.SearchItemModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    var likedItems: ArrayList<SearchItemModel> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.run {
            btnSearchFragment.setOnClickListener{
                setFragment(SearchFragment())
            }
            btnBookmarkFragment.setOnClickListener {
                setFragment(BookmarkFragment())
            }
        }

        setFragment(Searchfragment())
    }

    private fun setFragment(frag : Fragment) {
        supportFragmentManager.commit {
            replace(R.id.frameLayout, frag)
            setReorderingAllowed(true)
            addToBackStack(null)
        }
    }

    fun addLikedItem(item: SearchItemModel) {
        if(!likedItems.contains(item)) {
            likedItems.add(item)
        }
    }

    fun removeLikedItem(item: SearchItemModel) {
        likedItems.remove(item)
    }
}
