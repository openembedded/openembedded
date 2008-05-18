SECTION = "console/network"
require php_${PV}.bb
inherit native
FILESPATH = "${FILE_DIRNAME}/php-${PV}:${FILE_DIRNAME}/php:${FILE_DIRNAME}/files"
DEPENDS = "zlib-native"
PR = "r2"

S = "${WORKDIR}/php-${PV}"
