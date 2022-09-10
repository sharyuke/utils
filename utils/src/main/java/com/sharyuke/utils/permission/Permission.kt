package com.sharyuke.utils.permission

data class Permission(
  val permission: String,
  val isGranted: Boolean,
  val shouldShowRational: Boolean = false
)
