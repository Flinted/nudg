package chris.did.presentation.usecase

/**
 * Failure
 */
sealed class Failure {

    class NetworkConnection : Failure()
    class ServerError : Failure()
    class GeneralError : Failure()
    class CannotSaveNudgFailure : Failure()
    class CannotCreateNudgFailure : Failure()
    class NudgNotFoundFailure : Failure()

    abstract class FeatureFailure : Failure()
}