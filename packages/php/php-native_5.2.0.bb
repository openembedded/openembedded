SECTION = "console/network"
require php_${PV}.bb
inherit autotools native pkgconfig
export LIBS=" -lxml2 "
export LD_LIBRARY_PATH = "${STAGING_LIBDIR}"

FILESPATH = "${FILE_DIRNAME}/php-${PV}:${FILE_DIRNAME}/php:${FILE_DIRNAME}/files"
DEPENDS = "zlib-native libxml2-native"

