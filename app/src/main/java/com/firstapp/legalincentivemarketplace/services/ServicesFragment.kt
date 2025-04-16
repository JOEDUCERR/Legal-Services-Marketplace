package com.firstapp.legalincentivemarketplace.services
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.firstapp.legalincentivemarketplace.R
import com.firstapp.legalincentivemarketplace.models.ServiceStatus
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.legalservices.marketplace.ui.services.AddServiceFragment

class ServicesFragment : Fragment() {

    private lateinit var viewPager: ViewPager2
    private lateinit var tabLayout: TabLayout
    private lateinit var addServiceFab: FloatingActionButton

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_services, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewPager = view.findViewById(R.id.viewPager)
        tabLayout = view.findViewById(R.id.tabLayout)
        addServiceFab = view.findViewById(R.id.addServiceFab)
        setupViewPager()
        setupFab()
        parentFragmentManager.setFragmentResultListener("service_added", viewLifecycleOwner) { _, _ ->
            viewPager.visibility = View.VISIBLE
        }

    }

    private fun setupViewPager() {
        val categories = listOf(
            ServiceStatus.ACTIVE,
            ServiceStatus.COMPLETED,
            ServiceStatus.PENDING
        )

        viewPager.adapter = object : FragmentStateAdapter(this) {
            override fun getItemCount() = categories.size
            override fun createFragment(position: Int): Fragment {
                return ServiceListFragment.newInstance(categories[position])
            }
        }
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = categories[position].name
        }.attach()
    }

    private fun setupFab() {
        addServiceFab.setOnClickListener {
            viewPager.visibility=View.GONE
            // Navigate to AddServiceFragment when FAB is clicked
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, AddServiceFragment.newInstance())
                .addToBackStack(null)  // Add to back stack for back navigation
                .commit()
        }
    }

    companion object {
        fun newInstance() = ServicesFragment()
    }
}
