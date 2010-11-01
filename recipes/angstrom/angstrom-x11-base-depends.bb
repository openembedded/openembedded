DESCRIPTION = "Task packages for the Angstrom distribution"
LICENSE = "MIT"
PR = "r45"

inherit task

XSERVER ?= "xserver-xorg \
            xf86-input-evdev \
            xf86-input-tslib \
            xf86-input-mouse \
            xf86-video-fbdev \
            xf86-input-keyboard"

PACKAGE_ARCH = "${MACHINE_ARCH}"

DEPENDS = "virtual/xserver"

RDEPENDS_${PN} = "\
    ${XSERVER} \
    dbus-x11 \
    ttf-dejavu-sans \
    ttf-dejavu-sans-mono \
    "
