DESCRIPTION = "gphoto2 is a command-line utility to fetch pictures from digital cameras"
SECTION = "console/utils"
LICENSE = "GPL"
DEPENDS = "libgphoto2 popt"
PR = "r1"

SRC_URI = "${SOURCEFORGE_MIRROR}/gphoto/gphoto2-${PV}.tar.bz2"

inherit autotools

SRC_URI[md5sum] = "5bbee55d4e59b063d3cff0fbc9121006"
SRC_URI[sha256sum] = "c52e77a52ad11a02ae9f0b8491915f3f09fec23f8f740cc6079570241caf63cb"
