require php_${PV}.bb

SECTION = "console/network"
DEPENDS = "zlib-native libxml2-native mysql-native"
PR = "r2"

S = "${WORKDIR}/php-${PV}"

inherit autotools native pkgconfig
export LIBS=" -lxml2 "
export LD_LIBRARY_PATH = "${STAGING_LIBDIR}"

FILESPATH = "${FILE_DIRNAME}/php-${PV}:${FILE_DIRNAME}/php:${FILE_DIRNAME}/files"
