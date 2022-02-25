package com.example.andrayim

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.andrayim.databinding.EpisodeFragmentBinding
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class EpisodeFragment: Fragment(R.layout.episode_fragment) {
    private val api get() = Injector.breakingBadApi
    private var _binding: EpisodeFragmentBinding ?= null
    private val binding get() = _binding!!
    private lateinit var listener: Clicked

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as Clicked
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = EpisodeFragmentBinding.bind(view)
        val id = arguments?.getLong("id") ?: 1L

        binding.apply {
            api.getEpisodeById(id)
                .subscribeOn(Schedulers.io())
                .map { it.first() }
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSuccess {
                    episodeTitle.text = "Title: ${it.title}"
                    episodeSeason.text = "Season: ${it.season}"
                    episode.text = "Episode: ${it.episode}"
                    episodeCharacters.text = "Characters: ${it.characters.toString()}"
                    episodeDate.text = "Date: ${it.air_date}"
                    episodesSeries.text = "Series: ${it.series}"
                }
                .observeOn(Schedulers.io())
                .doOnSuccess {

                }
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSuccess {
                    //
                }
                .subscribe()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}