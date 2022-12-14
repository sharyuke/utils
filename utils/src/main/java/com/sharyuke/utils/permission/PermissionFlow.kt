package com.sharyuke.utils.permission

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import kotlinx.coroutines.flow.flow

internal object PermissionFlow {
    private val FRAGMENT_TAG = PermissionFragment::class.java.simpleName

    internal fun request(fragment: Fragment, vararg permissionsToRequest: String) =
        request(fragment.childFragmentManager, *permissionsToRequest)

    internal fun request(activity: FragmentActivity, vararg permissionsToRequest: String) =
        request(activity.supportFragmentManager, *permissionsToRequest)

    internal fun requestEach(fragment: Fragment, vararg permissionsToRequest: String) =
        requestEach(fragment.childFragmentManager, *permissionsToRequest)

    internal fun requestEach(activity: FragmentActivity, vararg permissionsToRequest: String) =
        requestEach(activity.supportFragmentManager, *permissionsToRequest)

    private fun request(fragmentManager: FragmentManager, vararg permissionsToRequest: String) = flow {
        createFragment(fragmentManager).takeIf { permissionsToRequest.isNotEmpty() }?.run {
            request(*permissionsToRequest)
            val results = completableDeferred.await()
            if (results.isNotEmpty()) {
                emit(results)
            }
        }
    }

    private fun requestEach(fragmentManager: FragmentManager, vararg permissionsToRequest: String) = flow {
        createFragment(fragmentManager).takeIf { permissionsToRequest.isNotEmpty() }?.run {
            request(*permissionsToRequest)
            val results = completableDeferred.await()
            results.forEach { emit(it) }
        }
    }

    private fun createFragment(fragmentManager: FragmentManager): PermissionFragment {
        val fragment = fragmentManager.findFragmentByTag(FRAGMENT_TAG)?.let { it as PermissionFragment } ?: PermissionFragment.newInstance()
        if (!fragment.isAdded) fragmentManager.beginTransaction().add(fragment, FRAGMENT_TAG).commitNow()
        return fragment
    }
}

// Extensions
fun FragmentActivity.permissionsRequest(vararg permissionsToRequest: String) = PermissionFlow.request(this, *permissionsToRequest)
fun FragmentActivity.permissionsRequestEach(vararg permissionsToRequest: String) = PermissionFlow.requestEach(this, *permissionsToRequest)
fun Fragment.permissionsRequest(vararg permissionsToRequest: String) = PermissionFlow.request(this, *permissionsToRequest)
fun Fragment.permissionsRequestEach(vararg permissionsToRequest: String) = PermissionFlow.requestEach(this, *permissionsToRequest)
