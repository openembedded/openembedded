DESCRIPTION = "gphoto2 is a command-line utility to fetch pictures from digital cameras"
SECTION = "console/utils"
LICENSE = "GPL"
DEPENDS = "libgphoto2 popt"
PR = "r2"

SRC_URI = "${SOURCEFORGE_MIRROR}/gphoto/gphoto2-${PV}.tar.gz"

inherit autotools

SRC_URI[md5sum] = "2de2bcc62599b8a7337b54b0a067c50b"
SRC_URI[sha256sum] = "82330519effc421a39c196d2a2806dc9c3cdcc891b7ec34dee04b3fe4ef4534a"
