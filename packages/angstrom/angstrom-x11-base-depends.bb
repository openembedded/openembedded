DESCRIPTION = "Task packages for the Angstrom distribution"
PR = "r38"

inherit task

XSERVER ?= "xserver-kdrive-fbdev"

PACKAGE_ARCH = "${MACHINE_ARCH}"

DEPENDS = "virtual/xserver"

RDEPENDS = "\
    ${XSERVER} \
    dbus-x11 \
    ttf-dejavu-sans \
    ttf-dejavu-sans-mono \
    "

