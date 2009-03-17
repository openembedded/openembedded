require glibc_${PV}.bb
require glibc-initial.inc

DEFAULT_PREFERENCE_sh3 = "-99"
FILESPATH = "${@base_set_filespath([ '${FILE_DIRNAME}/glibc-${PV}', '${FILE_DIRNAME}/glibc', '${FILE_DIRNAME}/files', '${FILE_DIRNAME}' ], d)}"

PROVIDES_unslung = "virtual/${TARGET_PREFIX}libc-initial"
