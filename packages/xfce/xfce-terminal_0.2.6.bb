DESCRIPTION = "Terminal emulator for the Xfce desktop environment"
DEPENDS = "exo vte dbus-glib gtk+"

inherit xfce

SRC_URI = "http://www.us.xfce.org/archive/xfce-4.4.1/src/Terminal-${PV}.tar.bz2"

S = "${WORKDIR}/Terminal-${PV}"
