package chris.did.nudg.base

import android.arch.lifecycle.AndroidViewModel
import android.databinding.Observable
import android.databinding.PropertyChangeRegistry
import io.reactivex.disposables.CompositeDisposable
import org.reactivestreams.Subscription

/**
 * BaseViewModel
 */
open class BaseViewModel(application: BaseApplication) : AndroidViewModel(application),
    Observable {

    protected var disposables: CompositeDisposable? = CompositeDisposable()

    private val subscriptions: MutableMap<String, Subscription> = mutableMapOf()

    private val callbacks: PropertyChangeRegistry by lazy { PropertyChangeRegistry() }

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback) {
        callbacks.add(callback)
    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback) {
        callbacks.remove(callback)
    }

    fun notifyChange() {
        callbacks.notifyCallbacks(this, 0, null)
    }

    fun notifyPropertyChanged(fieldId: Int) {
        callbacks.notifyCallbacks(this, fieldId, null)
    }

    override fun onCleared() {
        super.onCleared()
        disposables?.dispose()
        disposables?.clear()
        disposables = null
    }
}