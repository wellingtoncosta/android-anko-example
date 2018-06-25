package br.com.wellingtoncosta.example.anko.presentation

import android.net.Uri
import android.support.constraint.ConstraintSet.PARENT_ID
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import br.com.wellingtoncosta.example.anko.R
import br.com.wellingtoncosta.example.anko.model.Contact
import br.com.wellingtoncosta.example.anko.presentation.common.simpleDraweeView
import com.facebook.drawee.generic.RoundingParams
import com.facebook.drawee.view.SimpleDraweeView
import org.jetbrains.anko.*
import org.jetbrains.anko.constraint.layout.ConstraintSetBuilder.Side.*
import org.jetbrains.anko.constraint.layout.applyConstraintSet
import org.jetbrains.anko.constraint.layout.constraintLayout

/**
 * @author Wellington Costa on 25/06/18.
 */
class ListContactsViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    val image: SimpleDraweeView = itemView.find(R.id.list_contact_item_image)
    val name: TextView = itemView.find(R.id.list_contact_item_txt_name)

    fun bind(contact: Contact) {
        image.imageURI = Uri.parse(contact.photo)
        name.text = contact.name
    }

    class Layout : AnkoComponent<ViewGroup> {

        override fun createView(ui: AnkoContext<ViewGroup>) = with(ui) {
            constraintLayout {
                val image = simpleDraweeView {
                    id = R.id.list_contact_item_image
                    val roundingParams = RoundingParams.fromCornersRadius(5f)
                    roundingParams.roundAsCircle = true
                    hierarchy.roundingParams = roundingParams
                }.lparams(width = dip(60), height = dip(60)) {
                    padding = dip(8)
                }

                val name = textView {
                    id = R.id.list_contact_item_txt_name
                    textSize = 16f
                }.lparams { leftMargin = dip(16) }

                applyConstraintSet {
                    image {
                        connect(
                                TOP to TOP of PARENT_ID,
                                LEFT to LEFT of PARENT_ID
                        )
                    }
                    name {
                        connect(
                                TOP to TOP of image,
                                RIGHT to RIGHT of PARENT_ID,
                                LEFT to RIGHT of image,
                                BOTTOM to BOTTOM of image
                        )
                    }
                }
            }
        }

    }

}