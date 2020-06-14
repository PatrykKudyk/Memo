package com.example.memo.fragments

import android.content.Context
import android.media.Image
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.content.ContextCompat
import com.example.memo.R
import com.example.memo.models.ImageSet
import kotlinx.android.synthetic.main.fragment_small_game.*
import kotlin.random.Random


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [AccountFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [AccountFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SmallGameFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var listener: OnFragmentInteractionListener? = null

    private lateinit var rootView: View
    private lateinit var backButton: View
    private lateinit var imageArray: Array<Array<ImageSet>>
    private lateinit var small00: ImageView
    private lateinit var small01: ImageView
    private lateinit var small02: ImageView
    private lateinit var small03: ImageView
    private lateinit var small10: ImageView
    private lateinit var small11: ImageView
    private lateinit var small12: ImageView
    private lateinit var small13: ImageView
    private lateinit var small20: ImageView
    private lateinit var small21: ImageView
    private lateinit var small22: ImageView
    private lateinit var small23: ImageView
    private lateinit var small30: ImageView
    private lateinit var small31: ImageView
    private lateinit var small32: ImageView
    private lateinit var small33: ImageView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootView = inflater.inflate(R.layout.fragment_small_game, container, false);
        initFragment()
        return rootView
    }

    fun onButtonPressed(uri: Uri) {
        listener?.onFragmentInteraction(uri)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onFragmentInteraction(uri: Uri)
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            SmallGameFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }

    private fun initFragment() {
        backButton = rootView.findViewById(R.id.back_button)

        backButton.setOnClickListener {
            fragmentManager
                ?.popBackStack()
        }
        initImageArray()
        shuffleImages()
        implementLogic()
    }

    private fun initImageArray() {
        small00 = rootView.findViewById(R.id.small_00)
        small01 = rootView.findViewById(R.id.small_01)
        small02 = rootView.findViewById(R.id.small_02)
        small03 = rootView.findViewById(R.id.small_03)
        small10 = rootView.findViewById(R.id.small_10)
        small11 = rootView.findViewById(R.id.small_11)
        small12 = rootView.findViewById(R.id.small_12)
        small13 = rootView.findViewById(R.id.small_13)
        small20 = rootView.findViewById(R.id.small_20)
        small21 = rootView.findViewById(R.id.small_21)
        small22 = rootView.findViewById(R.id.small_22)
        small23 = rootView.findViewById(R.id.small_23)
        small30 = rootView.findViewById(R.id.small_30)
        small31 = rootView.findViewById(R.id.small_31)
        small32 = rootView.findViewById(R.id.small_32)
        small33 = rootView.findViewById(R.id.small_33)

        val array1 = arrayOf(
            ImageSet(small00, false, -1),
            ImageSet(small01, false, -1),
            ImageSet(small02, false, -1),
            ImageSet(small03, false, -1)
        )
        val array2 = arrayOf(
            ImageSet(small10, false, -1),
            ImageSet(small11, false, -1),
            ImageSet(small12, false, -1),
            ImageSet(small13, false, -1)
        )
        val array3 = arrayOf(
            ImageSet(small20, false, -1),
            ImageSet(small21, false, -1),
            ImageSet(small22, false, -1),
            ImageSet(small23, false, -1)
        )
        val array4 = arrayOf(
            ImageSet(small30, false, -1),
            ImageSet(small31, false, -1),
            ImageSet(small32, false, -1),
            ImageSet(small33, false, -1)
        )

        imageArray = arrayOf(array1, array2, array3, array4)

        for (i in 0..3) {
            for (j in 0..3) {
                imageArray[i][j].imageView.setImageDrawable(
                    ContextCompat.getDrawable(
                        rootView.context,
                        R.drawable.cards_background
                    )
                )
            }
        }
    }

    private fun shuffleImages() {
        var numbers = arrayOf(2, 2, 2, 2, 2, 2, 2, 2)

        for (i in 0..3) {
            for (j in 0..3) {
                var number: Int
                do {
                    number = Random.nextInt(0, 8)
                } while (numbers[number] == 0)
                numbers[number]--
                imageArray[i][j].imageNumber = number
            }
        }

    }



    private fun setImage(x: Int, y: Int, number: Int) {
        when (number) {
            0 -> {
                imageArray[x][y].imageView.setImageDrawable(
                    ContextCompat.getDrawable(
                        rootView.context,
                        R.drawable.character_fin
                    )
                )
                imageArray[x][y].imageNumber = 0
            }
            1 -> {
                imageArray[x][y].imageView.setImageDrawable(
                    ContextCompat.getDrawable(
                        rootView.context,
                        R.drawable.character_jake
                    )
                )
                imageArray[x][y].imageNumber = 1
            }
            2 -> {
                imageArray[x][y].imageView.setImageDrawable(
                    ContextCompat.getDrawable(
                        rootView.context,
                        R.drawable.character_marcelina
                    )
                )
                imageArray[x][y].imageNumber = 2
            }
            3 -> {
                imageArray[x][y].imageView.setImageDrawable(
                    ContextCompat.getDrawable(
                        rootView.context,
                        R.drawable.character_peppermint
                    )
                )
                imageArray[x][y].imageNumber = 3
            }
            4 -> {
                imageArray[x][y].imageView.setImageDrawable(
                    ContextCompat.getDrawable(
                        rootView.context,
                        R.drawable.character_gunter
                    )
                )
                imageArray[x][y].imageNumber = 4
            }
            5 -> {
                imageArray[x][y].imageView.setImageDrawable(
                    ContextCompat.getDrawable(
                        rootView.context,
                        R.drawable.character_kgk
                    )
                )
                imageArray[x][y].imageNumber = 5
            }
            6 -> {
                imageArray[x][y].imageView.setImageDrawable(
                    ContextCompat.getDrawable(
                        rootView.context,
                        R.drawable.character_ice_king
                    )
                )
                imageArray[x][y].imageNumber = 6
            }
            7 -> {
                imageArray[x][y].imageView.setImageDrawable(
                    ContextCompat.getDrawable(
                        rootView.context,
                        R.drawable.character_princess_bubblegum
                    )
                )
                imageArray[x][y].imageNumber = 7
            }
        }
    }

    private fun implementLogic() {
        
    }

}