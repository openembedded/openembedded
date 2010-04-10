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


SRC_URI[md5sum] = "bcc5621e09802e114c7f72a6f6172230"
SRC_URI[sha256sum] = "68cd94664882fdab5fa781b4b8fabe1ac49db7d97bdf3aa917563439afa9b9b6"
