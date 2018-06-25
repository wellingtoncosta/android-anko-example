package br.com.wellingtoncosta.example.anko.presentation

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import br.com.wellingtoncosta.example.anko.model.Contact
import org.jetbrains.anko.AnkoContext

/**
 * @author Wellington Costa on 25/06/18.
 */
class ListContactsAdapter(
        private val contacts: List<Contact>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ListContactsViewHolder(
                ListContactsViewHolder.Layout().createView(
                        AnkoContext.create(parent.context, parent)
                )
        )
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as ListContactsViewHolder).bind(contacts[position])
    }

    override fun getItemCount(): Int {
        return if (contacts.isNotEmpty()) contacts.size else 0
    }

}