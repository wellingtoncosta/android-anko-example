package br.com.wellingtoncosta.example.anko.presentation

import android.arch.lifecycle.Observer
import android.support.constraint.ConstraintSet.PARENT_ID
import android.support.v4.content.ContextCompat.getColor
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import br.com.wellingtoncosta.example.anko.R
import br.com.wellingtoncosta.example.anko.model.Response
import org.jetbrains.anko.*
import org.jetbrains.anko.constraint.layout.ConstraintSetBuilder.Side.*
import org.jetbrains.anko.constraint.layout.applyConstraintSet
import org.jetbrains.anko.constraint.layout.constraintLayout
import org.jetbrains.anko.design.appBarLayout
import org.jetbrains.anko.recyclerview.v7.recyclerView
import org.jetbrains.anko.support.v4.swipeRefreshLayout

/**
 * @author Wellington Costa on 24/06/18.
 */
class ListContactsLayout(
        private val viewModel: ListContactsViewModel
) : AnkoComponent<ListContactsActivity> {

    override fun createView(ui: AnkoContext<ListContactsActivity>) = with(ui) {
        constraintLayout {
            val appBar = appBarLayout {
                id = R.id.list_contact_appbar
                toolbar {
                    id = R.id.list_contact_toolbar
                    title = context.getString(R.string.contacts_list)
                    setTitleTextColor(getColor(context, R.color.colorWhite))
                }
            }.lparams(width = matchParent, height = wrapContent)

            val swipe = swipeRefreshLayout {
                id = R.id.list_contact_swipe_layout
                viewModel.isRefreshing.observe(ui.owner, Observer {
                    isRefreshing = it ?: false
                })
                setOnRefreshListener { viewModel.loadAll() }
                recyclerView {
                    id = R.id.list_contact_recycler_view
                    val orientation = LinearLayoutManager.VERTICAL
                    layoutManager = LinearLayoutManager(context)
                    addItemDecoration(DividerItemDecoration(context, orientation))
                    viewModel.response.observe(ui.owner, Observer {
                        it?.let {
                            adapter = when {
                                it.status == Response.Status.SUCCESS -> it.data?.let {
                                    ListContactsAdapter(it)
                                }
                                it.status == Response.Status.ERROR -> {
                                    longToast(context.getString(R.string.fetch_contacts_failure))
                                    ListContactsAdapter(emptyList())
                                }
                                else -> ListContactsAdapter(emptyList())
                            }
                        }
                    })
                }
            }

            applyConstraintSet {
                appBar {
                    connect(
                            TOP to TOP of PARENT_ID
                    )
                }
                swipe {
                    connect(
                            TOP to BOTTOM of appBar,
                            START to START of PARENT_ID,
                            END to END of PARENT_ID
                    )
                }
            }
        }
    }

}