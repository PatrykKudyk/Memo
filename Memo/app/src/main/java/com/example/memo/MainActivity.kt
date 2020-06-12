package com.example.memo

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tictactoe.fragments.*

class MainActivity : AppCompatActivity(),
    BigGameFragment.OnFragmentInteractionListener,
    MainMenuFragment.OnFragmentInteractionListener,
    MediumGameFragment.OnFragmentInteractionListener,
    SizeChoiceFragment.OnFragmentInteractionListener,
    SmallGameFragment.OnFragmentInteractionListener {

    lateinit var mainMenuFragment: MainMenuFragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mainMenuFragment = MainMenuFragment.newInstance()

        supportFragmentManager
            .beginTransaction()
            .add(R.id.frame_layout, mainMenuFragment)
            .commit()
    }

    override fun onFragmentInteraction(uri: Uri) {

    }
}