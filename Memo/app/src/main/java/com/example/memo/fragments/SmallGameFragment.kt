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
class SmallGameFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var listener: OnFragmentInteractionListener? = null

    private lateinit var rootView: View
    private lateinit var backButton: View
    private lateinit var imageArray: Array<Array<ImageSet>>
    private lateinit var cCell: Array<Int>
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
            ImageSet(small00, false, -1, false),
            ImageSet(small01, false, -1, false),
            ImageSet(small02, false, -1, false),
            ImageSet(small03, false, -1, false)
        )
        val array2 = arrayOf(
            ImageSet(small10, false, -1, false),
            ImageSet(small11, false, -1, false),
            ImageSet(small12, false, -1, false),
            ImageSet(small13, false, -1, false)
        )
        val array3 = arrayOf(
            ImageSet(small20, false, -1, false),
            ImageSet(small21, false, -1, false),
            ImageSet(small22, false, -1, false),
            ImageSet(small23, false, -1, false)
        )
        val array4 = arrayOf(
            ImageSet(small30, false, -1, false),
            ImageSet(small31, false, -1, false),
            ImageSet(small32, false, -1, false),
            ImageSet(small33, false, -1, false)
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
        }
    }

    private fun setBackground(x: Int, y: Int) {
        imageArray[x][y].imageView.setImageDrawable(
            ContextCompat.getDrawable(
                rootView.context,
                R.drawable.cards_background
            )
        )
    }

    private fun checkOpened() {
        var first = arrayOf(-1, -1)
        var second = arrayOf(-1, -1)
        for (i in 0..3) {
            for (j in 0..3) {
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
        for (i in 0..3) {
            for (j in 0..3) {
                if (!imageArray[i][j].isDone) {
                    return false
                }
            }
        }
        val winFragment = WinFragment.newInstance(1)
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
    }
}
