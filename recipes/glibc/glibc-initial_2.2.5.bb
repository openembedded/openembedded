require glibc_${PV}.bb
require glibc-initial.inc

DEFAULT_PREFERENCE_sh3 = "-99"

PROVIDES_unslung = "virtual/${TARGET_PREFIX}libc-initial"
