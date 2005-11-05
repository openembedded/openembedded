SECTION = "console/utils"
DEPENDS = "openssl jpeg libpng zlib"
DESCRIPTION = "An Internet printing system for Unix."
LICENSE = "GPL LGPL"

SRC_URI = "ftp://ftp.easysw.com/pub/cups/${PV}/cups-${PV}-source.tar.bz2"

inherit autotools

do_compile () {
	oe_runmake "SSLLIBS=-lssl -lcrypto -L${STAGING_LIBDIR}" \
		   "LIBPNG=-lpng -lm -L${STAGING_LIBDIR}" \
		   "LIBJPEG=-ljpeg -L${STAGING_LIBDIR}" \
		   "LIBZ=-lz -L${STAGING_LIBDIR}"
}

do_install () {
	oe_runmake "DSTROOT=${D}" install
}
