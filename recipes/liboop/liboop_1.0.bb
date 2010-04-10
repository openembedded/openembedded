SECTION = "libs"
DESCRIPTION = "Liboop is a low-level event loop management library \
for POSIX-based operating systems."
LICENSE = "LGPL"

SRC_URI = "http://download.ofb.net/liboop/liboop-${PV}.tar.bz2"
S = "${WORKDIR}/liboop-${PV}"

inherit autotools  pkgconfig

EXTRA_OECONF = "--without-tcl --without-glib \
                --without-readline --without-adns"

headers = "oop.h oop-adns.h oop-glib.h \
	  oop-tcl.h oop-www.h oop-rl.h \
	  oop-read.h"
do_stage () {
	oe_libinstall -a -so liboop ${STAGING_LIBDIR}
	install -m 0644 ${headers} ${STAGING_INCDIR}/
}

SRC_URI[md5sum] = "88fc8decf99fd75d2af40e0a005fa0d3"
SRC_URI[sha256sum] = "4a973d28466fde0b689099192f9bcd081b129d90b3c5a9815e5ade73052cf8d2"
