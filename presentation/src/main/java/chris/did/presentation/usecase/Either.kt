package chris.did.presentation.usecase

/**
 * Either
 */
sealed class Either<out L, out R> {

    data class Fail<out L>(val failValue: L) : Either<L, Nothing>()
    data class Success<out R>(val successValue: R) : Either<Nothing, R>()

    internal val isSuccess get() = this is Success<R>
    internal val isFail get() = this is Fail<L>

    internal fun <L> fail(failValue: L) = Either.Fail(failValue)
    internal fun <R> success(successValue: R) = Either.Success(successValue)

    internal fun <T> either(functionFail: (L) -> T, functionSuccess: (R) -> T): T =
        when (this) {
            is Fail    -> functionFail(failValue)
            is Success -> functionSuccess(successValue)
        }

    private fun <A, B, C> ((A) -> B).c(f: (B) -> C): (A) -> C = {
        f(this(it))
    }

    private fun <T, L, R> Either<L, R>.flatMap(mapFunction: (R) -> Either<L, T>): Either<L, T> =
        when (this) {
            is Fail    -> Either.Fail(failValue)
            is Success -> mapFunction(successValue)
        }

    private fun <T, L, R> Either<L, R>.map(mapFunction: (R) -> (T)): Either<L, T> = this.flatMap(mapFunction.c(::success))
}
