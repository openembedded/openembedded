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

SRC_URI[md5sum] = "adb419d279c9fc16d02291c052190717"
SRC_URI[sha256sum] = "352205b03e9ed1b9080c61235fbc0fa15609410e724237441055a232a3b603dc"
