package chris.did.presentation.nudgdetail.usecases

import chris.did.data.nudgservice.NudgServicable
import chris.did.presentation.nudg.Nudg
import chris.did.presentation.nudgfactory.NudgCreator
import chris.did.presentation.usecase.Either
import chris.did.presentation.usecase.Either.Fail
import chris.did.presentation.usecase.Either.Success
import chris.did.presentation.usecase.Failure
import chris.did.presentation.usecase.Failure.NudgNotFoundFailure
import chris.did.presentation.usecase.UseCase
import java.util.*

/**
 * GetNudgByIdUseCase
 */
class GetNudgByIdUseCase(
    private val nudgService: NudgServicable,
    private val nudgFactory: NudgCreator
) : UseCase<Nudg, UUID>() {

    override suspend fun run(params: UUID): Either<Failure, Nudg> {
        val realmNudg = nudgService.getNudgById(params) ?: return Fail(NudgNotFoundFailure())
        val nudg = nudgFactory.convertToNudg(realmNudg)
        return Success(nudg)
    }
}