package chris.did.presentation.base

/**
 * BasePresenter
 */
abstract class BasePresenter<T : BaseListener> : BasePresentable<T> {

    protected var presenterListener: T? = null

    override fun setListener(listener: T) {
        this.presenterListener = listener
    }

    override fun onDestroy() {
        presenterListener = null
    }
}
