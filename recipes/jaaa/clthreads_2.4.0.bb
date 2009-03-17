DESCRIPTION = "clthreads library from http://www.kokkinizita.net/linuxaudio/"
SECTION = "libs/multimedia"
PRIORITY = "optional"
LICENSE = "LGPL"
PR = "r0"

DEPENDS = ""

SRC_URI = "http://www.kokkinizita.net/linuxaudio/downloads/clthreads-${PV}.tar.bz2 \
	file://clthreads-Makefile.patch;patch=1 \
"

S = "${WORKDIR}/clthreads-${PV}"

inherit autotools pkgconfig lib_package

do_stage() {
       autotools_stage_all
	   oe_libinstall -so libclthreads ${STAGING_LIBDIR}
	   install -m 0644 clthreads.h ${STAGING_INCDIR}
}
