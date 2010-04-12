DESCRIPTION = "gphoto2 is a command-line utility to fetch pictures from digital cameras"
SECTION = "console/utils"
LICENSE = "GPL"
DEPENDS = "libtool libgphoto2 popt"
PR = "r0"

SRC_URI = "${SOURCEFORGE_MIRROR}/gphoto/gphoto2-${PV}.tar.bz2\
           file://gphoto-popt-fixup.patch;patch=1"

inherit autotools

do_configure_append() {
        find ${S} -name Makefile | xargs sed -i 's:/usr/include:${STAGING_INCDIR}:'
}


SRC_URI[md5sum] = "a0bd7629040735f16e510b63edf386dd"
SRC_URI[sha256sum] = "16e21ab5387220ad885e1d27f936f3add4081d15a1039577002682be521b2c03"
