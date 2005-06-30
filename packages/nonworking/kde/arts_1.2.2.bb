DEPENDS = "glib-2.0-native qt-x11-free-native"
DESCRIPTION = "Analog Real Time Synthesizer... (ARTS)"
MAINTAINER = "Holger Freyther <zecke@handhelds.org>"
LICENSE = "GPL"
PRIOTITY = "optional"
SECTION = "kde"

SRC_URI = "http://download.kde.org/download.php?url=stable/3.2.2/src/arts-${PV}.tar.bz2"

S = "${WORKDIR}/arts-${PV}"

inherit autotools native
