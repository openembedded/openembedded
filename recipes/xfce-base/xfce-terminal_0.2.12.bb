DESCRIPTION = "Terminal emulator for the Xfce desktop environment"
DEPENDS = "exo vte dbus-glib gtk+"
RDEPENDS += "gnome-pty-helper"
PR = "r2"

inherit xfce46

XFCE_VERSION = "4.6.1"

SRC_URI = "http://www.us.xfce.org/archive/xfce-${XFCE_VERSION}/src/Terminal-${PV}.tar.bz2 \
"

S = "${WORKDIR}/Terminal-${PV}"

FILES_${PN} += "${datadir}/Terminal"
