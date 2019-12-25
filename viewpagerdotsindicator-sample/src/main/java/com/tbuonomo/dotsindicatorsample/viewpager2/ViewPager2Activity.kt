package com.tbuonomo.dotsindicatorsample.viewpager2

import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.tbuonomo.dotsindicatorsample.R
import com.tbuonomo.dotsindicatorsample.viewpager.ZoomOutPageTransformer
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator
import com.tbuonomo.viewpagerdotsindicator.SpringDotsIndicator
import com.tbuonomo.viewpagerdotsindicator.WormDotsIndicator

class ViewPager2Activity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    requestWindowFeature(Window.FEATURE_NO_TITLE)
    window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN)
    setContentView(R.layout.activity_view_pager2)

    val dotsIndicator = findViewById<DotsIndicator>(R.id.dots_indicator)
    val springDotsIndicator = findViewById<SpringDotsIndicator>(R.id.spring_dots_indicator)
    val wormDotsIndicator = findViewById<WormDotsIndicator>(R.id.worm_dots_indicator)
    val deleteButton = findViewById<Button>(R.id.button_delete)

    val viewPager2 = findViewById<ViewPager2>(R.id.view_pager2)
    val items = mutableListOf("1", "2", "3", "4", "5")
    val adapter = DotIndicatorPager2Adapter(items)
    viewPager2.adapter = adapter

    val zoomOutPageTransformer = ZoomOutPageTransformer()
    viewPager2.setPageTransformer { page, position ->
      zoomOutPageTransformer.transformPage(page, position)
    }

    dotsIndicator.setViewPager2(viewPager2)
    springDotsIndicator.setViewPager2(viewPager2)
    wormDotsIndicator.setViewPager2(viewPager2)

    deleteButton.setOnClickListener {
      items.removeAt(0)
      viewPager2.adapter?.notifyDataSetChanged()
    }

  }
}
