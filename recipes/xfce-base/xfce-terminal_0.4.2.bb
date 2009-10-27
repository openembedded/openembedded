DESCRIPTION = "Terminal emulator for the Xfce desktop environment"
DEPENDS = "exo vte dbus-glib gtk+"
RDEPENDS += "gnome-pty-helper"
PR = "r2"

inherit xfce46

SRC_URI = "http://www.xfce.org/archive/src/apps/terminal/0.4/Terminal-${PV}.tar.bz2 \
"

S = "${WORKDIR}/Terminal-${PV}"

FILES_${PN} += "${datadir}/Terminal"
