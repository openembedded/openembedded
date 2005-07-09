LICENSE = "GPL"
SECTION = "console/utils"
DEPENDS = "libgphoto2 popt"
DESCRIPTION = "gphoto2 is a command-line utility to fetch pictures from digital cameras"

SRC_URI = "${SOURCEFORGE_MIRROR}/gphoto/gphoto2-${PV}.tar.gz"

inherit autotools
