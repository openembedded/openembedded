require glibc_${PV}.bb
require glibc-intermediate.inc

DEFAULT_PREFERENCE_sh3 = "-99"

GLIBC_ADDONS = "linuxthreads"
