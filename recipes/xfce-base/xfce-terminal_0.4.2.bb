DESCRIPTION = "Terminal emulator for the Xfce desktop environment"
DEPENDS = "exo vte dbus-glib gtk+"
RDEPENDS += "gnome-pty-helper"
PR = "r2"

inherit xfce46

SRC_URI = "http://www.xfce.org/archive/src/apps/terminal/0.4/Terminal-${PV}.tar.bz2 \
"

S = "${WORKDIR}/Terminal-${PV}"

FILES_${PN} += "${datadir}/Terminal"

SRC_URI[md5sum] = "9754afef6b79fa1df9aaf41fb8cc6374"
SRC_URI[sha256sum] = "4d5a07f3a1b68c9825cc3b82fc2672785ba91247a34e4ac462841f0b1ea21079"
