DESCRIPTION = "GNU libmicrohttpd is a small C library that is supposed to make it easy to run an HTTP server as part of another application"
HOMEPAGE = "http://www.gnu.org/software/libmicrohttpd/"
SECTION = "libs"
LICENSE = "LGPL"
PR = "r1"

SRC_URI = "ftp://ftp.gnu.org/gnu/libmicrohttpd/libmicrohttpd-0.4.1.tar.gz"

inherit autotools pkgconfig

do_stage() {
        oe_runmake DESTDIR="${D}" install
        autotools_stage_all
}

PN = "libmicrohttpd"
