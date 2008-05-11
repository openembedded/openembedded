DESCRIPTION = "clalsadrv library from http://www.kokkinizita.net/linuxaudio/"
SECTION = "libs/multimedia"
PRIORITY = "optional"
LICENSE = "GPL"
PR = "r0"

DEPENDS = "alsa-lib"

SRC_URI = "http://www.kokkinizita.net/linuxaudio/downloads/clalsadrv-${PV}.tar.bz2 \
	file://clalsadrv-Makefile.patch;patch=1 \
"

S = "${WORKDIR}/clalsadrv"

inherit autotools pkgconfig lib_package

do_stage() {
       autotools_stage_all
	   oe_libinstall -so libclalsadrv ${STAGING_LIBDIR}
	   install -m 0644 clalsadrv.h ${STAGING_INCDIR}
}
