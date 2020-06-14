package com.example.memo.fragments

import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.content.ContextCompat
import com.example.memo.R
import com.example.memo.models.ImageSet
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
class BigGameFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var listener: OnFragmentInteractionListener? = null

    private lateinit var rootView: View
    private lateinit var backButton: View
    private lateinit var imageArray: Array<Array<ImageSet>>
    private lateinit var cCell: Array<Int>
    private lateinit var big00: ImageView
    private lateinit var big01: ImageView
    private lateinit var big02: ImageView
    private lateinit var big03: ImageView
    private lateinit var big04: ImageView
    private lateinit var big05: ImageView
    private lateinit var big10: ImageView
    private lateinit var big11: ImageView
    private lateinit var big12: ImageView
    private lateinit var big13: ImageView
    private lateinit var big14: ImageView
    private lateinit var big15: ImageView
    private lateinit var big20: ImageView
    private lateinit var big21: ImageView
    private lateinit var big22: ImageView
    private lateinit var big23: ImageView
    private lateinit var big24: ImageView
    private lateinit var big25: ImageView
    private lateinit var big30: ImageView
    private lateinit var big31: ImageView
    private lateinit var big32: ImageView
    private lateinit var big33: ImageView
    private lateinit var big34: ImageView
    private lateinit var big35: ImageView
    private lateinit var big40: ImageView
    private lateinit var big41: ImageView
    private lateinit var big42: ImageView
    private lateinit var big43: ImageView
    private lateinit var big44: ImageView
    private lateinit var big45: ImageView
    private lateinit var big50: ImageView
    private lateinit var big51: ImageView
    private lateinit var big52: ImageView
    private lateinit var big53: ImageView
    private lateinit var big54: ImageView
    private lateinit var big55: ImageView

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
        rootView = inflater.inflate(R.layout.fragment_big_game, container, false);
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
            BigGameFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }

    private fun initFragment() {
        backButton = rootView.findViewById(R.id.back_button)
        cCell = arrayOf(-1, -1)
        backButton.setOnClickListener {
            fragmentManager
                ?.popBackStack()
        }
        initImageArray()
        shuffleImages()
        implementLogic()
    }

    private fun initImageArray() {
        big00 = rootView.findViewById(R.id.big_00)
        big01 = rootView.findViewById(R.id.big_01)
        big02 = rootView.findViewById(R.id.big_02)
        big03 = rootView.findViewById(R.id.big_03)
        big04 = rootView.findViewById(R.id.big_04)
        big05 = rootView.findViewById(R.id.big_05)
        big10 = rootView.findViewById(R.id.big_10)
        big11 = rootView.findViewById(R.id.big_11)
        big12 = rootView.findViewById(R.id.big_12)
        big13 = rootView.findViewById(R.id.big_13)
        big14 = rootView.findViewById(R.id.big_14)
        big15 = rootView.findViewById(R.id.big_15)
        big20 = rootView.findViewById(R.id.big_20)
        big21 = rootView.findViewById(R.id.big_21)
        big22 = rootView.findViewById(R.id.big_22)
        big23 = rootView.findViewById(R.id.big_23)
        big24 = rootView.findViewById(R.id.big_24)
        big25 = rootView.findViewById(R.id.big_25)
        big30 = rootView.findViewById(R.id.big_30)
        big31 = rootView.findViewById(R.id.big_31)
        big32 = rootView.findViewById(R.id.big_32)
        big33 = rootView.findViewById(R.id.big_33)
        big34 = rootView.findViewById(R.id.big_34)
        big35 = rootView.findViewById(R.id.big_35)
        big40 = rootView.findViewById(R.id.big_40)
        big41 = rootView.findViewById(R.id.big_41)
        big42 = rootView.findViewById(R.id.big_42)
        big43 = rootView.findViewById(R.id.big_43)
        big44 = rootView.findViewById(R.id.big_44)
        big45 = rootView.findViewById(R.id.big_45)
        big50 = rootView.findViewById(R.id.big_50)
        big51 = rootView.findViewById(R.id.big_51)
        big52 = rootView.findViewById(R.id.big_52)
        big53 = rootView.findViewById(R.id.big_53)
        big54 = rootView.findViewById(R.id.big_54)
        big55 = rootView.findViewById(R.id.big_55)

        val array1 = arrayOf(
            ImageSet(big00, false, -1, false),
            ImageSet(big01, false, -1, false),
            ImageSet(big02, false, -1, false),
            ImageSet(big03, false, -1, false),
            ImageSet(big04, false, -1, false),
            ImageSet(big05, false, -1, false)
        )
        val array2 = arrayOf(
            ImageSet(big10, false, -1, false),
            ImageSet(big11, false, -1, false),
            ImageSet(big12, false, -1, false),
            ImageSet(big13, false, -1, false),
            ImageSet(big14, false, -1, false),
            ImageSet(big15, false, -1, false)
        )
        val array3 = arrayOf(
            ImageSet(big20, false, -1, false),
            ImageSet(big21, false, -1, false),
            ImageSet(big22, false, -1, false),
            ImageSet(big23, false, -1, false),
            ImageSet(big24, false, -1, false),
            ImageSet(big25, false, -1, false)
        )
        val array4 = arrayOf(
            ImageSet(big30, false, -1, false),
            ImageSet(big31, false, -1, false),
            ImageSet(big32, false, -1, false),
            ImageSet(big33, false, -1, false),
            ImageSet(big34, false, -1, false),
            ImageSet(big35, false, -1, false)
        )

        val array5 = arrayOf(
            ImageSet(big40, false, -1, false),
            ImageSet(big41, false, -1, false),
            ImageSet(big42, false, -1, false),
            ImageSet(big43, false, -1, false),
            ImageSet(big44, false, -1, false),
            ImageSet(big45, false, -1, false)
        )

        val array6 = arrayOf(
            ImageSet(big50, false, -1, false),
            ImageSet(big51, false, -1, false),
            ImageSet(big52, false, -1, false),
            ImageSet(big53, false, -1, false),
            ImageSet(big54, false, -1, false),
            ImageSet(big55, false, -1, false)
        )

        imageArray = arrayOf(array1, array2, array3, array4, array5, array6)

        for (i in 0..5) {
            for (j in 0..5) {
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
        var numbers = arrayOf(2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2)

        for (i in 0..5) {
            for (j in 0..5) {
                var number: Int
                do {
                    number = Random.nextInt(0, 18)
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
            }
            1 -> {
                imageArray[x][y].imageView.setImageDrawable(
                    ContextCompat.getDrawable(
                        rootView.context,
                        R.drawable.character_jake
                    )
                )
            }
            2 -> {
                imageArray[x][y].imageView.setImageDrawable(
                    ContextCompat.getDrawable(
                        rootView.context,
                        R.drawable.character_marcelina
                    )
                )
            }
            3 -> {
                imageArray[x][y].imageView.setImageDrawable(
                    ContextCompat.getDrawable(
                        rootView.context,
                        R.drawable.character_peppermint
                    )
                )
            }
            4 -> {
                imageArray[x][y].imageView.setImageDrawable(
                    ContextCompat.getDrawable(
                        rootView.context,
                        R.drawable.character_gunter
                    )
                )
            }
            5 -> {
                imageArray[x][y].imageView.setImageDrawable(
                    ContextCompat.getDrawable(
                        rootView.context,
                        R.drawable.character_kgk
                    )
                )
            }
            6 -> {
                imageArray[x][y].imageView.setImageDrawable(
                    ContextCompat.getDrawable(
                        rootView.context,
                        R.drawable.character_ice_king
                    )
                )
            }
            7 -> {
                imageArray[x][y].imageView.setImageDrawable(
                    ContextCompat.getDrawable(
                        rootView.context,
                        R.drawable.character_princess_bubblegum
                    )
                )
            }
            8 -> {
                imageArray[x][y].imageView.setImageDrawable(
                    ContextCompat.getDrawable(
                        rootView.context,
                        R.drawable.character_unicorn
                    )
                )
            }
            9 -> {
                imageArray[x][y].imageView.setImageDrawable(
                    ContextCompat.getDrawable(
                        rootView.context,
                        R.drawable.character_bmo
                    )
                )
            }
            10 -> {
                imageArray[x][y].imageView.setImageDrawable(
                    ContextCompat.getDrawable(
                        rootView.context,
                        R.drawable.character_death
                    )
                )
            }
            11 -> {
                imageArray[x][y].imageView.setImageDrawable(
                    ContextCompat.getDrawable(
                        rootView.context,
                        R.drawable.character_cinnamone
                    )
                )
            }
            12 -> {
                imageArray[x][y].imageView.setImageDrawable(
                    ContextCompat.getDrawable(
                        rootView.context,
                        R.drawable.character_princess_hot_dog
                    )
                )
            }
            13 -> {
                imageArray[x][y].imageView.setImageDrawable(
                    ContextCompat.getDrawable(
                        rootView.context,
                        R.drawable.character_princess_ghost
                    )
                )
            }
            14 -> {
                imageArray[x][y].imageView.setImageDrawable(
                    ContextCompat.getDrawable(
                        rootView.context,
                        R.drawable.character_princess_breakfast
                    )
                )
            }
            15 -> {
                imageArray[x][y].imageView.setImageDrawable(
                    ContextCompat.getDrawable(
                        rootView.context,
                        R.drawable.character_pertikov
                    )
                )
            }
            16 -> {
                imageArray[x][y].imageView.setImageDrawable(
                    ContextCompat.getDrawable(
                        rootView.context,
                        R.drawable.character_susan
                    )
                )
            }
            17 -> {
                imageArray[x][y].imageView.setImageDrawable(
                    ContextCompat.getDrawable(
                        rootView.context,
                        R.drawable.character_skrobek
                    )
                )
            }
        }
    }

    private fun checkOpened() {
        var first = arrayOf(-1, -1)
        var second = arrayOf(-1, -1)
        for (i in 0..5) {
            for (j in 0..5) {
                if (imageArray[i][j].isOpened) {
                    if (first[0] == -1) {
                        first[0] = i
                        first[1] = j
                    } else {
                        second[0] = i
                        second[1] = j
                    }
                }
            }
        }
        if (second[0] != -1) {
            if (imageArray[first[0]][first[1]].imageNumber == imageArray[second[0]][second[1]].imageNumber) {
                imageArray[first[0]][first[1]].imageView.setImageDrawable(
                    ContextCompat.getDrawable(
                        rootView.context,
                        R.drawable.card_done
                    )
                )
                imageArray[first[0]][first[1]].imageView.isClickable = false
                imageArray[first[0]][first[1]].isOpened = false
                imageArray[first[0]][first[1]].isDone = true
                imageArray[second[0]][second[1]].imageView.setImageDrawable(
                    ContextCompat.getDrawable(
                        rootView.context,
                        R.drawable.card_done
                    )
                )
                imageArray[second[0]][second[1]].imageView.isClickable = false
                imageArray[second[0]][second[1]].isOpened = false
                imageArray[second[0]][second[1]].isDone = true
            } else {
                imageArray[first[0]][first[1]].imageView.setImageDrawable(
                    ContextCompat.getDrawable(
                        rootView.context,
                        R.drawable.cards_background
                    )
                )
                imageArray[first[0]][first[1]].isOpened = false
                imageArray[second[0]][second[1]].imageView.setImageDrawable(
                    ContextCompat.getDrawable(
                        rootView.context,
                        R.drawable.cards_background
                    )
                )
                imageArray[second[0]][second[1]].isOpened = false
            }
        }

    }

    private fun isEnd(): Boolean {
        for (i in 0..5) {
            for (j in 0..5) {
                if (!imageArray[i][j].isDone) {
                    return false
                }
            }
        }
        val winFragment = WinFragment.newInstance(3)
        fragmentManager
            ?.beginTransaction()
            ?.setCustomAnimations(
                R.anim.enter_left_to_right, R.anim.exit_right_to_left,
                R.anim.enter_right_to_left, R.anim.exit_left_to_right
            )
            ?.replace(R.id.frame_layout, winFragment)
            ?.commit()
        return true
    }

    private fun implementLogic() {

        imageArray[0][0].imageView.setOnClickListener {
            setImage(0, 0, imageArray[0][0].imageNumber)
            imageArray[0][0].isOpened = true
            Handler().postDelayed(
                {
                    checkOpened()
                    isEnd()
                }, 260
            )
        }
        imageArray[0][1].imageView.setOnClickListener {
            setImage(0, 1, imageArray[0][1].imageNumber)
            imageArray[0][1].isOpened = true
            Handler().postDelayed(
                {
                    checkOpened()
                    isEnd()
                }, 260
            )
        }
        imageArray[0][2].imageView.setOnClickListener {
            setImage(0, 2, imageArray[0][2].imageNumber)
            imageArray[0][2].isOpened = true
            Handler().postDelayed(
                {
                    checkOpened()
                    isEnd()
                }, 260
            )
        }
        imageArray[0][3].imageView.setOnClickListener {
            setImage(0, 3, imageArray[0][3].imageNumber)
            imageArray[0][3].isOpened = true
            Handler().postDelayed(
                {
                    checkOpened()
                    isEnd()
                }, 260
            )
        }
        imageArray[0][4].imageView.setOnClickListener {
            setImage(0, 4, imageArray[0][4].imageNumber)
            imageArray[0][4].isOpened = true
            Handler().postDelayed(
                {
                    checkOpened()
                    isEnd()
                }, 260
            )
        }
        imageArray[0][5].imageView.setOnClickListener {
            setImage(0, 5, imageArray[0][5].imageNumber)
            imageArray[0][5].isOpened = true
            Handler().postDelayed(
                {
                    checkOpened()
                    isEnd()
                }, 260
            )
        }
        imageArray[1][0].imageView.setOnClickListener {
            setImage(1, 0, imageArray[1][0].imageNumber)
            imageArray[1][0].isOpened = true
            Handler().postDelayed(
                {
                    checkOpened()
                    isEnd()
                }, 260
            )
        }
        imageArray[1][1].imageView.setOnClickListener {
            setImage(1, 1, imageArray[1][1].imageNumber)
            imageArray[1][1].isOpened = true
            Handler().postDelayed(
                {
                    checkOpened()
                    isEnd()
                }, 260
            )
        }
        imageArray[1][2].imageView.setOnClickListener {
            setImage(1, 2, imageArray[1][2].imageNumber)
            imageArray[1][2].isOpened = true
            Handler().postDelayed(
                {
                    checkOpened()
                    isEnd()
                }, 260
            )
        }
        imageArray[1][3].imageView.setOnClickListener {
            setImage(1, 3, imageArray[1][3].imageNumber)
            imageArray[1][3].isOpened = true
            Handler().postDelayed(
                {
                    checkOpened()
                    isEnd()
                }, 260
            )
        }
        imageArray[1][4].imageView.setOnClickListener {
            setImage(1, 4, imageArray[1][4].imageNumber)
            imageArray[1][4].isOpened = true
            Handler().postDelayed(
                {
                    checkOpened()
                    isEnd()
                }, 260
            )
        }
        imageArray[1][5].imageView.setOnClickListener {
            setImage(1, 5, imageArray[1][5].imageNumber)
            imageArray[1][5].isOpened = true
            Handler().postDelayed(
                {
                    checkOpened()
                    isEnd()
                }, 260
            )
        }
        imageArray[2][0].imageView.setOnClickListener {
            setImage(2, 0, imageArray[2][0].imageNumber)
            imageArray[2][0].isOpened = true
            Handler().postDelayed(
                {
                    checkOpened()
                    isEnd()
                }, 260
            )
        }
        imageArray[2][1].imageView.setOnClickListener {
            setImage(2, 1, imageArray[2][1].imageNumber)
            imageArray[2][1].isOpened = true
            Handler().postDelayed(
                {
                    checkOpened()
                    isEnd()
                }, 260
            )
        }
        imageArray[2][2].imageView.setOnClickListener {
            setImage(2, 2, imageArray[2][2].imageNumber)
            imageArray[2][2].isOpened = true
            Handler().postDelayed(
                {
                    checkOpened()
                    isEnd()
                }, 260
            )
        }
        imageArray[2][3].imageView.setOnClickListener {
            setImage(2, 3, imageArray[2][3].imageNumber)
            imageArray[2][3].isOpened = true
            Handler().postDelayed(
                {
                    checkOpened()
                    isEnd()
                }, 260
            )
        }
        imageArray[2][4].imageView.setOnClickListener {
            setImage(2, 4, imageArray[2][4].imageNumber)
            imageArray[2][4].isOpened = true
            Handler().postDelayed(
                {
                    checkOpened()
                    isEnd()
                }, 260
            )
        }
        imageArray[2][5].imageView.setOnClickListener {
            setImage(2, 5, imageArray[2][5].imageNumber)
            imageArray[2][5].isOpened = true
            Handler().postDelayed(
                {
                    checkOpened()
                    isEnd()
                }, 260
            )
        }

        imageArray[3][0].imageView.setOnClickListener {
            setImage(3, 0, imageArray[3][0].imageNumber)
            imageArray[3][0].isOpened = true
            Handler().postDelayed(
                {
                    checkOpened()
                    isEnd()
                }, 260
            )
        }
        imageArray[3][1].imageView.setOnClickListener {
            setImage(3, 1, imageArray[3][1].imageNumber)
            imageArray[3][1].isOpened = true
            Handler().postDelayed(
                {
                    checkOpened()
                    isEnd()
                }, 260
            )
        }
        imageArray[3][2].imageView.setOnClickListener {
            setImage(3, 2, imageArray[3][2].imageNumber)
            imageArray[3][2].isOpened = true
            Handler().postDelayed(
                {
                    checkOpened()
                    isEnd()
                }, 260
            )
        }
        imageArray[3][3].imageView.setOnClickListener {
            setImage(3, 3, imageArray[3][3].imageNumber)
            imageArray[3][3].isOpened = true
            Handler().postDelayed(
                {
                    checkOpened()
                    isEnd()
                }, 260
            )
        }
        imageArray[3][4].imageView.setOnClickListener {
            setImage(3, 4, imageArray[3][4].imageNumber)
            imageArray[3][4].isOpened = true
            Handler().postDelayed(
                {
                    checkOpened()
                    isEnd()
                }, 260
            )
        }
        imageArray[3][5].imageView.setOnClickListener {
            setImage(3, 5, imageArray[3][5].imageNumber)
            imageArray[3][5].isOpened = true
            Handler().postDelayed(
                {
                    checkOpened()
                    isEnd()
                }, 260
            )
        }
        imageArray[4][0].imageView.setOnClickListener {
            setImage(4, 0, imageArray[4][0].imageNumber)
            imageArray[4][0].isOpened = true
            Handler().postDelayed(
                {
                    checkOpened()
                    isEnd()
                }, 260
            )
        }
        imageArray[4][1].imageView.setOnClickListener {
            setImage(4, 1, imageArray[4][1].imageNumber)
            imageArray[4][1].isOpened = true
            Handler().postDelayed(
                {
                    checkOpened()
                    isEnd()
                }, 260
            )
        }
        imageArray[4][2].imageView.setOnClickListener {
            setImage(4, 2, imageArray[4][2].imageNumber)
            imageArray[4][2].isOpened = true
            Handler().postDelayed(
                {
                    checkOpened()
                    isEnd()
                }, 260
            )
        }
        imageArray[4][3].imageView.setOnClickListener {
            setImage(4, 3, imageArray[4][3].imageNumber)
            imageArray[4][3].isOpened = true
            Handler().postDelayed(
                {
                    checkOpened()
                    isEnd()
                }, 260
            )
        }
        imageArray[4][4].imageView.setOnClickListener {
            setImage(4, 4, imageArray[4][4].imageNumber)
            imageArray[4][4].isOpened = true
            Handler().postDelayed(
                {
                    checkOpened()
                    isEnd()
                }, 260
            )
        }
        imageArray[4][5].imageView.setOnClickListener {
            setImage(4, 5, imageArray[4][5].imageNumber)
            imageArray[4][5].isOpened = true
            Handler().postDelayed(
                {
                    checkOpened()
                    isEnd()
                }, 260
            )
        }
        imageArray[5][0].imageView.setOnClickListener {
            setImage(5, 0, imageArray[5][0].imageNumber)
            imageArray[5][0].isOpened = true
            Handler().postDelayed(
                {
                    checkOpened()
                    isEnd()
                }, 260
            )
        }
        imageArray[5][1].imageView.setOnClickListener {
            setImage(5, 1, imageArray[5][1].imageNumber)
            imageArray[5][1].isOpened = true
            Handler().postDelayed(
                {
                    checkOpened()
                    isEnd()
                }, 260
            )
        }
        imageArray[5][2].imageView.setOnClickListener {
            setImage(5, 2, imageArray[5][2].imageNumber)
            imageArray[5][2].isOpened = true
            Handler().postDelayed(
                {
                    checkOpened()
                    isEnd()
                }, 260
            )
        }
        imageArray[5][3].imageView.setOnClickListener {
            setImage(5, 3, imageArray[5][3].imageNumber)
            imageArray[5][3].isOpened = true
            Handler().postDelayed(
                {
                    checkOpened()
                    isEnd()
                }, 260
            )
        }
        imageArray[5][4].imageView.setOnClickListener {
            setImage(5, 4, imageArray[5][4].imageNumber)
            imageArray[5][4].isOpened = true
            Handler().postDelayed(
                {
                    checkOpened()
                    isEnd()
                }, 260
            )
        }
        imageArray[5][5].imageView.setOnClickListener {
            setImage(5, 5, imageArray[5][5].imageNumber)
            imageArray[5][5].isOpened = true
            Handler().postDelayed(
                {
                    checkOpened()
                    isEnd()
                }, 260
            )
        }
    }
}