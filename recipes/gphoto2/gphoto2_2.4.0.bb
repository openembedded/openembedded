DESCRIPTION = "gphoto2 is a command-line utility to fetch pictures from digital cameras"
SECTION = "console/utils"
LICENSE = "GPL"
DEPENDS = "libtool libgphoto2 popt"
PR = "r0"

SRC_URI = "${SOURCEFORGE_MIRROR}/gphoto/gphoto2-${PV}.tar.bz2"

inherit autotools

do_configure_append() {
        find ${S} -name Makefile | xargs sed -i 's:/usr/include:${STAGING_INCDIR}:'
}


SRC_URI[md5sum] = "5fd1f711ca806adb687b33c55964d898"
SRC_URI[sha256sum] = "8aa5ac34dae18284f3f04db874648a6dc70ecee3045ace674351b7326ae1c4e5"
