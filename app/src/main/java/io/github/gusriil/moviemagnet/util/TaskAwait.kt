package io.github.gusriil.moviemagnet.util

import com.google.android.play.core.tasks.Task
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

suspend fun <ResultT> Task<ResultT>.await() = suspendCoroutine<ResultT> { cont ->
    addOnSuccessListener {
        cont.resume(it)
    }
    addOnFailureListener {
        cont.resumeWithException(it)
    }
}