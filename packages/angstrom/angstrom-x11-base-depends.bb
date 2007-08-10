DESCRIPTION = "Task packages for the Angstrom distribution"
PR = "r35"
ALLOW_EMPTY = "1"

XSERVER ?= "xserver-kdrive-fbdev"

PACKAGE_ARCH = "${MACHINE_ARCH}"

DEPENDS = "virtual/xserver"

RDEPENDS = "\
    ${XSERVER} \
    ttf-dejavu-sans \
    ttf-dejavu-sans-mono \
    "

