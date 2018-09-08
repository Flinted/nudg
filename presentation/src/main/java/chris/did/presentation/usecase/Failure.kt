package chris.did.presentation.usecase

/**
 * Failure
 */
sealed class Failure {

    class NetworkConnection: Failure()
    class ServerError: Failure()

    abstract class FeatureFailure: Failure()
}