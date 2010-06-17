DESCRIPTION = "Terminal emulator for the Xfce desktop environment"
DEPENDS = "exo vte dbus-glib gtk+"
RDEPENDS_${PN} += "gnome-pty-helper"
PR = "r0"

inherit xfce46

SRC_URI = "http://www.xfce.org/archive/src/apps/terminal/0.4/Terminal-${PV}.tar.bz2 \
"

S = "${WORKDIR}/Terminal-${PV}"

FILES_${PN} += "${datadir}/Terminal"

SRC_URI[md5sum] = "3c707628e2e97c6d9566cd74d400036a"
SRC_URI[sha256sum] = "92fddcbc1422076672d8ec61832793d4ceea2fc0db7d724a6acde0ec2bac8893"
