SECTION = "x11/libs"
DESCRIPTION = "Matchbox window manager core library"
LICENSE = "GPL"
DEPENDS = "x11 xext libxft pango jpeg libpng zlib libxsettings-client"
PV = "1.5cvs${CVSDATE}"
DEFAULT_PREFERENCE = "-1"

SRC_URI = "svn://svn.o-hand.com/repos/matchbox/trunk;module=${PN};proto=http\
		file://check.m4"
inherit autotools  pkgconfig

EXTRA_OECONF = "--enable-jpeg --enable-pango --enable-xsettings"

S = ${WORKDIR}/${PN}

headers = "hash.h mbconfig.h mbdotdesktop.h mbexp.h \
	   mb.h mbmenu.h mbpixbuf.h mbtray.h mbutil.h"

do_configure_prepend () {
        mv ${WORKDIR}/check.m4 ${S}/
}



do_stage () {
	install -d ${STAGING_INCDIR}/libmb
	for h in ${headers}; do
		install -m 0644 ${S}/libmb/$h ${STAGING_INCDIR}/libmb/
	done

	oe_libinstall -a -so -C libmb libmb ${STAGING_LIBDIR}
}
