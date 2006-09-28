SECTION = "libs"
require zlib_${PV}.bb
ZLIB_EXTRA = ""
inherit native

DEPENDS = "libtool-native"
FILESPATH = "${@base_set_filespath([ '${FILE_DIRNAME}/zlib-${PV}', '${FILE_DIRNAME}/zlib', '${FILE_DIRNAME}/files', '${FILE_DIRNAME}' ], d)}"
