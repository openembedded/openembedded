DESCRIPTION = "easy to embed and small HTTP server as a C library"
AUTHOR = "Christian Grothoff <christian@grothoff.org>"
HOMEPAGE = "http://www.gnu.org/software/libmicrohttpd/"
SECTION = "libs"
LICENSE = "LGPL"
PR = "r2"

SRC_URI = "ftp://ftp.gnu.org/gnu/libmicrohttpd/libmicrohttpd-${PV}.tar.gz"

inherit autotools pkgconfig

do_stage() {
        oe_runmake DESTDIR="${D}" install
        autotools_stage_all
}

SRC_URI[md5sum] = "2853d8f32417e3c5f3b18fda38f96e52"
SRC_URI[sha256sum] = "1e095469f7d159e5b9c91106484e10f0b3ce3265c55b9864407bd4ea5952111f"
