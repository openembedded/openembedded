DESCRIPTION = "gphoto2 is a command-line utility to fetch pictures from digital cameras"
SECTION = "console/utils"
LICENSE = "GPL"
DEPENDS = "libgphoto2 popt"
PR = "r1"

SRC_URI = "${SOURCEFORGE_MIRROR}/gphoto/gphoto2-${PV}.tar.gz"

inherit autotools

SRC_URI[md5sum] = "9bd1a033389f9e4e6425dda4f6e603c9"
SRC_URI[sha256sum] = "fefaabea8aede51ae9560ba71e2a7c31f4d856b0bb1fc0de7297d12e1215698c"
