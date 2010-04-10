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

SRC_URI[md5sum] = "7865b6c175e457ea9cb0148ce8baa746"
SRC_URI[sha256sum] = "0fed89dd092936b5ffa74ad7df77a72b8cbeec8cea226ff48e107e326bd36f50"
