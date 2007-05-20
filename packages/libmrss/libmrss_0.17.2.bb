DESCRIPTION = "mRSS is a C library for parsing, writing and creating RSS (0.91, 0.92, 1.0, 2.0) files or streams"
LICENSE = "LGPL"
HOMEPAGE = "http://www2.autistici.org/bakunin/codes.php"

DEPENDS = "libnxml curl"
PR      = "r1"

inherit autotools pkgconfig

SRC_URI = "http://www2.autistici.org/bakunin/libmrss/libmrss-${PV}.tar.gz \
           file://better-parse-url-r0.patch;patch=1                       "

do_stage() {
    autotools_stage_all
}
