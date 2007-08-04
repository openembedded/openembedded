DESCRIPTION = "Task packages for the Angstrom distribution"
PR = "r33"
ALLOW_EMPTY = "1"

XSERVER ?= "xserver-kdrive-fbdev"

PACKAGE_ARCH = "${MACHINE_ARCH}"

DEPENDS = "virtual/xserver"

RDEPENDS = "\
    virtual/libx11 \
    ${XSERVER} \
    ttf-dejavu-sans \
    ttf-dejavu-sans-mono \
    "

