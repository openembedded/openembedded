DESCRIPTION = "gphoto2 is a command-line utility to fetch pictures from digital cameras"
SECTION = "console/utils"
LICENSE = "GPL"
DEPENDS = "libtool libgphoto2 popt"

SRC_URI = "${SOURCEFORGE_MIRROR}/gphoto/gphoto2-${PV}.tar.bz2;name=gphoto2 \
           file://gphoto-popt-fixup.patch;patch=1"

SRC_URI[gphoto2.md5sum] = "401e403ea6e8301d6c87cbe7cd892b8b"
SRC_URI[gphoto2.sha256sum] = "a2e2f70fd6051234cbc3d76dc82df6991e8a07ead56aa8d5c4452e9bdb0e32a4"

inherit autotools

do_configure_append() {
        find ${S} -name Makefile | xargs sed -i 's:/usr/include:${STAGING_INCDIR}:'
}

