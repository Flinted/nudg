package chris.did.presentation.overview.usecases

import chris.did.data.nudgservice.NudgServicable
import chris.did.presentation.nudgfactory.NudgCreator
import chris.did.presentation.overview.usecases.SaveNudgUseCase.Params
import chris.did.presentation.usecase.Either
import chris.did.presentation.usecase.Either.Fail
import chris.did.presentation.usecase.Either.Success
import chris.did.presentation.usecase.Failure
import chris.did.presentation.usecase.Failure.CannotSaveNudgFailure
import chris.did.presentation.usecase.UseCase
import chris.did.presentation.usecase.UseCase.None
import io.realm.Realm

/**
 * SaveNudgUseCase
 */
class SaveNudgUseCase(
    private val nudgService: NudgServicable,
    private val nudgFactory: NudgCreator
) : UseCase<None, Params>() {

    data class Params(internal val nudgInput: String)

    override suspend fun run(params: Params): Either<Failure, None> {
        val nudg = nudgFactory.createNewNudg(params.nudgInput)
        val nudgData = nudgFactory.convertToNudgData(nudg)
        return try {
            nudgService.postNudg(nudgData, Realm.getDefaultInstance())
            Success(None())
        } catch (exception: Exception) {
            Fail(CannotSaveNudgFailure())
        }
    }
}