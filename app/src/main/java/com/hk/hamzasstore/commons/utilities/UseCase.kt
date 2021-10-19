package com.hk.hamzasstore.commons.utilities

abstract class UseCase<Input : UseCase.RequestValues, Output : Any?> {

    var requestValues: Input? = null

    abstract suspend fun executeUseCase(requestValues: Input? = null): Output?

    /**
     * Data passed to a request.
     */
    interface RequestValues

}