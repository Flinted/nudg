package chris.did.presentation.base

/**
 * BasePresentable
 */
interface BasePresentable<T: BaseListener> {

    fun setListener(listener: T)
    fun onDestroy()
}