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
