package com.mvvm.mvvmlearnkotlin.ui.dashboard.ui.Wallpaper

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.mvvm.mvvmlearnkotlin.databinding.FragmentWallpaperBinding
import com.mvvm.mvvmlearnkotlin.utils.NetworkResult
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_wallpaper.*
import javax.inject.Inject

@AndroidEntryPoint
class WallpaperFragment : Fragment() {

    private var _binding: FragmentWallpaperBinding? = null


    @Inject
    lateinit var adapter: WallpaperNewAdapter

   // private lateinit var wallpaperViewModel: WallpaperViewModel


    private val wallpaperViewModel by viewModels<WallpaperViewModel>()

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
       // wallpaperViewModel = ViewModelProvider(this).get(WallpaperViewModel::class.java)
        _binding = FragmentWallpaperBinding.inflate(inflater, container, false)
        val root: View = binding.root
      //  wallpaperViewModel.getWallpapers()
       // setupUI()
      //  setupObservers()
        binding.recyclerView.adapter = adapter

        wallpaperViewModel.wallpaperResponse.observe(viewLifecycleOwner) {
            when(it) {
                is NetworkResult.Loading -> {
                    binding.progressBar.isVisible = it.isLoading
                }

                is NetworkResult.Failure -> {
                    Log.e("Anitaqa", "onCreateView: "+it.errorMessage )
                    Toast.makeText(activity, it.errorMessage, Toast.LENGTH_SHORT).show()
                    binding.progressBar.isVisible = false

                }

                is  NetworkResult.Success -> {
                    it.data?.let { it1 -> adapter.updateMovies(it1) }
                    binding.progressBar.isVisible = false
                    binding.recyclerView.visibility = View.VISIBLE
                }
            }
        }

        return root
    }

    private fun setupUI() {
        binding.recyclerView.layoutManager = GridLayoutManager(activity, 2)
        adapter = WallpaperNewAdapter()
        binding.recyclerView.adapter = adapter
    }

    private fun setupObservers() {
//        wallpaperViewModel.wallpaperResponse.observe(viewLifecycleOwner) { resource ->
//            when (resource.status) {
//                Status.SUCCESS -> {
//                    binding.recyclerView.visibility = View.VISIBLE
//                    binding.progressBar.visibility = View.GONE
//                    resource.data?.let { users -> retrieveList(users) }
//                }
//                Status.ERROR -> {
//                    binding.recyclerView.visibility = View.VISIBLE
//                    binding.progressBar.visibility = View.GONE
//                    Toast.makeText(activity, resource.message, Toast.LENGTH_LONG).show()
//                }
//                Status.LOADING -> {
//                    binding.progressBar.visibility = View.VISIBLE
//                    binding.recyclerView.visibility = View.GONE
//                }
//            }
//        }

      //  binding.rvMovies.adapter = movieAdapter

//        movieAdapter.setItemClick(object : ClickInterface<Movie> {
//            override fun onClick(data: Movie) {
//                Toast.makeText(this@MainActivity, data.title, Toast.LENGTH_SHORT).show()
//            }
//        })

//        wallpaperViewModel.wallpaperResponse.observe(viewLifecycleOwner) {
//            when(it) {
//                is NetworkResult.Loading -> {
//                    binding.progressBar.isVisible = it.isLoading
//                }
//
//                is NetworkResult.Failure -> {
//                    Toast.makeText(activity, it.errorMessage, Toast.LENGTH_SHORT).show()
//                    binding.progressBar.isVisible = false
//                }
//
//                is  NetworkResult.Success -> {
//                    adapter.updateMovies(it.data)
//                    binding.progressBar.isVisible = false
//                }
//            }
//        }
    }



   /* private fun retrieveList(wallpaper: List<WallpaperResponseItem>) {
//        adapter.apply {
//            addUsers(wallpaper)
//            notifyDataSetChanged()
//
//        }
    }*/

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}