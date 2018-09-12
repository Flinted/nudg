package chris.did.presentation.overview.usecases

import chris.did.data.nudgservice.NudgServicable
import chris.did.presentation.nudg.Nudg
import chris.did.presentation.nudgfactory.NudgCreator
import chris.did.presentation.usecase.Either
import chris.did.presentation.usecase.Either.Success
import chris.did.presentation.usecase.Failure
import chris.did.presentation.usecase.UseCase
import chris.did.presentation.usecase.UseCase.None

/**
 * GetNudgsUseCase
 */
class GetNudgsUseCase(
    private val nudgService: NudgServicable,
    private val nudgFactory: NudgCreator
) : UseCase<List<Nudg>, None>() {

    override suspend fun run(params: None): Either<Failure, List<Nudg>> {
        val nudgData = nudgService.getNudgs()
        val nudgs = nudgData.map { data -> nudgFactory.convertToNudg(data) }
        return Success(nudgs)
    }
}
