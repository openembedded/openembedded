SECTION = "console/network"
include php_${PV}.bb
inherit native
FILESPATH = "${FILE_DIRNAME}/php-${PV}:${FILE_DIRNAME}/php:${FILE_DIRNAME}/files"
DEPENDS = "zlib-native"
