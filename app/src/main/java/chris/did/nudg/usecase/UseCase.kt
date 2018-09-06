package chris.did.nudg.usecase

import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.launch

/**
 * UseCase
 */
abstract class UseCase<out Type, in Params> where Type : Any {

    abstract suspend fun run(params: Params): Either<Failure, Type>

    operator fun invoke(params: Params, onResult: (Either<Failure, Type>) -> Unit = {}) {
        launch {
            async(CommonPool) { run(params) }.await().let { result ->
                onResult(result)
            }
        }
    }

    class None
}