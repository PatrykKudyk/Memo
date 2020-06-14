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
class MediumGameFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var listener: OnFragmentInteractionListener? = null

    private lateinit var rootView: View
    private lateinit var backButton: View
    private lateinit var imageArray: Array<Array<ImageSet>>
    private lateinit var cCell: Array<Int>
    private lateinit var medium00: ImageView
    private lateinit var medium01: ImageView
    private lateinit var medium02: ImageView
    private lateinit var medium03: ImageView
    private lateinit var medium04: ImageView
    private lateinit var medium10: ImageView
    private lateinit var medium11: ImageView
    private lateinit var medium12: ImageView
    private lateinit var medium13: ImageView
    private lateinit var medium14: ImageView
    private lateinit var medium20: ImageView
    private lateinit var medium21: ImageView
    private lateinit var medium22: ImageView
    private lateinit var medium23: ImageView
    private lateinit var medium24: ImageView
    private lateinit var medium30: ImageView
    private lateinit var medium31: ImageView
    private lateinit var medium32: ImageView
    private lateinit var medium33: ImageView
    private lateinit var medium34: ImageView
    private lateinit var medium40: ImageView
    private lateinit var medium41: ImageView
    private lateinit var medium42: ImageView
    private lateinit var medium43: ImageView
    private lateinit var medium44: ImageView


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
        rootView = inflater.inflate(R.layout.fragment_medium_game, container, false);
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
            MediumGameFragment().apply {
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

    private fun checkMiddle(x: Int, y: Int): Boolean {
        if (x == 2) {
            if (y == 2) {
                return true
            }
        }
        return false
    }

    private fun initImageArray() {
        medium00 = rootView.findViewById(R.id.medium_00)
        medium01 = rootView.findViewById(R.id.medium_01)
        medium02 = rootView.findViewById(R.id.medium_02)
        medium03 = rootView.findViewById(R.id.medium_03)
        medium04 = rootView.findViewById(R.id.medium_04)
        medium10 = rootView.findViewById(R.id.medium_10)
        medium11 = rootView.findViewById(R.id.medium_11)
        medium12 = rootView.findViewById(R.id.medium_12)
        medium13 = rootView.findViewById(R.id.medium_13)
        medium14 = rootView.findViewById(R.id.medium_14)
        medium20 = rootView.findViewById(R.id.medium_20)
        medium21 = rootView.findViewById(R.id.medium_21)
        medium22 = rootView.findViewById(R.id.medium_22)
        medium23 = rootView.findViewById(R.id.medium_23)
        medium24 = rootView.findViewById(R.id.medium_24)
        medium30 = rootView.findViewById(R.id.medium_30)
        medium31 = rootView.findViewById(R.id.medium_31)
        medium32 = rootView.findViewById(R.id.medium_32)
        medium33 = rootView.findViewById(R.id.medium_33)
        medium34 = rootView.findViewById(R.id.medium_34)
        medium40 = rootView.findViewById(R.id.medium_40)
        medium41 = rootView.findViewById(R.id.medium_41)
        medium42 = rootView.findViewById(R.id.medium_42)
        medium43 = rootView.findViewById(R.id.medium_43)
        medium44 = rootView.findViewById(R.id.medium_44)

        val array1 = arrayOf(
            ImageSet(medium00, false, -1, false),
            ImageSet(medium01, false, -1, false),
            ImageSet(medium02, false, -1, false),
            ImageSet(medium03, false, -1, false),
            ImageSet(medium04, false, -1, false)
        )
        val array2 = arrayOf(
            ImageSet(medium10, false, -1, false),
            ImageSet(medium11, false, -1, false),
            ImageSet(medium12, false, -1, false),
            ImageSet(medium13, false, -1, false),
            ImageSet(medium14, false, -1, false)
        )
        val array3 = arrayOf(
            ImageSet(medium20, false, -1, false),
            ImageSet(medium21, false, -1, false),
            ImageSet(medium22, false, -1, false),
            ImageSet(medium23, false, -1, false),
            ImageSet(medium24, false, -1, false)
        )
        val array4 = arrayOf(
            ImageSet(medium30, false, -1, false),
            ImageSet(medium31, false, -1, false),
            ImageSet(medium32, false, -1, false),
            ImageSet(medium33, false, -1, false),
            ImageSet(medium34, false, -1, false)
        )

        val array5 = arrayOf(
            ImageSet(medium40, false, -1, false),
            ImageSet(medium41, false, -1, false),
            ImageSet(medium42, false, -1, false),
            ImageSet(medium43, false, -1, false),
            ImageSet(medium44, false, -1, false)
        )

        imageArray = arrayOf(array1, array2, array3, array4, array5)

        for (i in 0..4) {
            for (j in 0..4) {
                if (!checkMiddle(i, j)) {
                    imageArray[i][j].imageView.setImageDrawable(
                        ContextCompat.getDrawable(
                            rootView.context,
                            R.drawable.cards_background
                        )
                    )
                }
            }
        }
        imageArray[2][2].imageView.isClickable = false
    }

    private fun shuffleImages() {
        var numbers = arrayOf(2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2)

        for (i in 0..4) {
            for (j in 0..4) {
                if (!checkMiddle(i, j)) {
                    var number: Int
                    do {
                        number = Random.nextInt(0, 12)
                    } while (numbers[number] == 0)
                    numbers[number]--
                    imageArray[i][j].imageNumber = number
                }
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
        }
    }

    private fun checkOpened() {
        var first = arrayOf(-1, -1)
        var second = arrayOf(-1, -1)
        for (i in 0..4) {
            for (j in 0..4) {
                if (!checkMiddle(i, j)) {
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
        for (i in 0..4) {
            for (j in 0..4) {
                if (!checkMiddle(i, j)) {
                    if (!imageArray[i][j].isDone) {
                        return false
                    }
                }
            }
        }
        val winFragment = WinFragment.newInstance(2)
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
    }
}