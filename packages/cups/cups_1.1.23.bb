DEPENDS = "openssl jpeg libpng zlib"
DESCRIPTION = "An Internet printing system for Unix."
SECTION = "console/utils"
LICENSE = "GPL LGPL"

SRC_URI = "ftp://ftp.easysw.com/pub/cups/${PV}/cups-${PV}-source.tar.bz2"

inherit autotools

LDFLAGS += " -L${STAGING_LIBDIR} "

do_compile () {
	#Eeeks! Hack alert!
	grep CUPS config.h.in~ | grep define >> config.h
	sed -i s:STRIP:NOSTRIP: Makedefs
	sed -i s:serial:: backend/Makefile

	oe_runmake "SSLLIBS=-lssl -lcrypto -L${STAGING_LIBDIR}" \
		   "LIBPNG=-lpng -lm -L${STAGING_LIBDIR}" \
		   "LIBJPEG=-ljpeg -L${STAGING_LIBDIR}" \
		   "LIBZ=-lz -L${STAGING_LIBDIR}" \
		   "-I."
}

do_install () {
	oe_runmake "DSTROOT=${D}" install
}
