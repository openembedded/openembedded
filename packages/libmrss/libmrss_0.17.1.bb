DESCRIPTION = "mRSS is a C library for parsing, writing and creating RSS (0.91, 0.92, 1.0, 2.0) files or streams"
LICENSE = "LGPL"
HOMEPAGE = "http://www2.autistici.org/bakunin/codes.php"

DEPENDS = "libnxml curl"
PR      = "r0"

inherit autotools pkgconfig

SRC_URI = "http://www2.autistici.org/bakunin/libmrss/libmrss-${PV}.tar.gz"

do_stage() {
    autotools_stage_all
}
