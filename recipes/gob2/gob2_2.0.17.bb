LICENSE = "LGPL"
DESCRIPTION = "A library to make creating GObjects easier"
HOMEPAGE = "http://www.5z.com/jirka/gob.html"
SECTION = "libs"
DEPENDS = "gtk+ bison flex"

SRC_URI = "http://ftp.5z.com/pub/gob/gob2-2.0.17.tar.gz"
SRC_URI[md5sum] = "05fa7384b30ebb2921430b2615d2c2e5"
SRC_URI[sha256sum] = "80b4683af653809970ef237fa45427b203653edf0dd5e3dc8897433e9c29346c"

inherit autotools pkgconfig

do_compile_prepend() {
    find ${S} -name Makefile | xargs sed -i 's~-I/usr/include~-I${STAGING_INCDIR}~g'
    find ${S} -name Makefile | xargs sed -i 's~-I$(includedir)~-I${STAGING_INCDIR}~g'
}

do_stage() {
    install -m 0644 ${S}/gob2.m4 ${STAGING_DATADIR}/aclocal
}

BBCLASSEXTEND = "native"

