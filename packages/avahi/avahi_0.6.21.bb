require avahi.inc
PR = "r1"

SRC_URI += "file://dbus-pre-1.1.1-support.patch;patch=1"

EXTRA_OECONF += "jm_cv_func_working_malloc=yes ac_cv_func_malloc_0_nonnull=yes jm_cv_func_working_realloc=yes ac_cv_func_realloc_0_nonnull=yes"

