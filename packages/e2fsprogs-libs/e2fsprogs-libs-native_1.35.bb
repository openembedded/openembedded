SECTION = "base"
include e2fsprogs-libs_${PV}.bb
inherit native

FILESPATH = "${@base_set_filespath([ '${FILE_DIRNAME}/e2fsprogs-libs-${PV}', '${FILE_DIRNAME}/e2fsprogs-libs', '${FILE_DIRNAME}/files', '${FILE_DIRNAME}' ], d)}"
PACKAGES = ""
