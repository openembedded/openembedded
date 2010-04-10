DESCRIPTION = "gphoto2 is a command-line utility to fetch pictures from digital cameras"
SECTION = "console/utils"
LICENSE = "GPL"
DEPENDS = "libtool libgphoto2 popt"
PR = "r1"

SRC_URI = "${SOURCEFORGE_MIRROR}/gphoto/gphoto2-${PV}.tar.bz2\
           file://gphoto-popt-fixup.patch;patch=1"

inherit autotools

do_configure_append() {
        find ${S} -name Makefile | xargs sed -i 's:/usr/include:${STAGING_INCDIR}:'
}


SRC_URI[md5sum] = "9c57dd8b89ccfeafdd2037516185f6e9"
SRC_URI[sha256sum] = "c9ef8c2f61bbe9978b38341ca2bf09786416ddd82d4708066a26a0483341ca72"
