DESCRIPTION = "mRSS is a C library for parsing, writing and creating RSS (0.91, 0.92, 1.0, 2.0) files or streams"
LICENSE = "LGPL"
HOMEPAGE = "http://www.autistici.org/bakunin/libmrss/"

DEPENDS = "libnxml curl"
INC_PR = "r1"

inherit autotools pkgconfig

SRC_URI = "http://www.autistici.org/bakunin/libmrss/libmrss-${PV}.tar.gz \
          "

