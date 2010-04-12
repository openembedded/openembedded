DESCRIPTION = "clxclient library from http://www.kokkinizita.net/linuxaudio/"
SECTION = "libs/multimedia"
PRIORITY = "optional"
LICENSE = "LGPL"
PR = "r0"

DEPENDS = "libx11 clthreads freetype libxft"
RDEPENDS = "libx11-locale"

SRC_URI = "http://www.kokkinizita.net/linuxaudio/downloads/clxclient-${PV}.tar.bz2 \
	file://clxclient-Makefile.patch;patch=1 \
"

S = "${WORKDIR}/clxclient-${PV}"

inherit autotools pkgconfig lib_package

do_stage() {
       autotools_stage_all
	   oe_libinstall -so libclxclient ${STAGING_LIBDIR}
	   install -m 0644 clxclient.h ${STAGING_INCDIR}
}

SRC_URI[md5sum] = "bd47f80a855d3203fcf10365e79d85e4"
SRC_URI[sha256sum] = "9de3e621d7acabb161b5926565a9c9373fedbc632222018f692346790149545d"
