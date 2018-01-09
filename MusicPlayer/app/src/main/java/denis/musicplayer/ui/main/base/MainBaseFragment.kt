package denis.musicplayer.ui.main.base

import android.content.Context
import android.support.v7.widget.LinearLayoutManager
import denis.musicplayer.R
import denis.musicplayer.data.media.model.Track
import denis.musicplayer.ui.base.BaseFragment
import denis.musicplayer.ui.main.MainActivity
import denis.musicplayer.ui.main.select.SelectFragment
import denis.musicplayer.ui.main.updateplaylist.UpdatePlaylistDialog
import denis.musicplayer.ui.player.fragment.PlayerFragment
import javax.inject.Inject

/**
 * Created by denis on 31/12/2017.
 */
abstract class MainBaseFragment<A : MainBaseAdapter<B, C, D, E>,
                                B: MainBaseViewHolder<C>,
                                C: Any,
                                D: MainBaseFragmentMvpView<C>,
                                E: MainBaseMvpPresenter<D, C>>
    : BaseFragment(), MainBaseFragmentMvpView<C> {

    private val TAG = "MainBaseFragment"

    @Inject lateinit var adapter: A

    @Inject lateinit var layoutManager: LinearLayoutManager

    private var baseActivity: MainBaseActivity? = null

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        baseActivity = activity as MainBaseActivity
    }
    
    override fun showSelectFragment() {
        baseActivity?.showSelectFragment()
    }

    override fun hideSelectFragment() {
        adapter.notifyDataSetChanged()
        baseActivity?.hideSelectFragment()
    }

    override fun updateCountSelectFragment(count: Int) {
        baseActivity?.updateCountSelectFragment(count)
    }

    override fun showUpdatePlaylist(array: ArrayList<Track>) {
        baseActivity?.showUpdatePlaylist(array)
    }

    override fun updateArray(array: ArrayList<C>) {
        adapter.updateArray(array)
    }
}