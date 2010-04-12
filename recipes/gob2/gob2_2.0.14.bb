LICENSE = "LGPL"
DESCRIPTION = "A library to make creating GObjects easier"
HOMEPAGE = "http://www.5z.com/jirka/gob.html"
SECTION = "libs"
DEPENDS = "gtk+ bison flex"
SRC_URI = "http://ftp.5z.com/pub/gob/old/gob2-${PV}.tar.gz"

inherit autotools pkgconfig

do_compile_prepend() {
    find ${S} -name Makefile | xargs sed -i 's~-I/usr/include~-I${STAGING_INCDIR}~g'
    find ${S} -name Makefile | xargs sed -i 's~-I$(includedir)~-I${STAGING_INCDIR}~g'
}

do_stage() {
    install -m 0644 ${S}/gob2.m4 ${STAGING_DATADIR}/aclocal
}

SRC_URI[md5sum] = "f8721af6f4e90ff48bd7cb4c96a5a94c"
SRC_URI[sha256sum] = "c2977b18d1166c62e3f04373feefc0e2af704da3cb98e32612be4a55fd77a3f9"
