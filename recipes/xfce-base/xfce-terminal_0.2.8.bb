DESCRIPTION = "Terminal emulator for the Xfce desktop environment"
DEPENDS = "exo vte dbus-glib gtk+"
RDEPENDS += "gnome-pty-helper"
PR = "r2"

inherit xfce

SRC_URI = "http://www.us.xfce.org/archive/xfce-4.4.2/src/Terminal-${PV}.tar.bz2 \
           file://into-support.patch;patch=1"

S = "${WORKDIR}/Terminal-${PV}"

SRC_URI[md5sum] = "cfe660ecf50e9d3b073576bbc4af6ab2"
SRC_URI[sha256sum] = "20a58b96915f67c5b4f49fb1428e1876195f1f9fd7d37e0081352cadc13463e7"
