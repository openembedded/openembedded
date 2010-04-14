DEPENDS = "glib-2.0-native qt-x11-free-native"
DESCRIPTION = "Analog Real Time Synthesizer... (ARTS)"
LICENSE = "GPL"
PRIOTITY = "optional"
SECTION = "kde"

SRC_URI = "http://download.kde.org/download.php?url=stable/3.2.2/src/arts-${PV}.tar.bz2"

SRC_URI[md5sum] = "83ca7e7a33c55de34e12bfc360190795"
SRC_URI[sha256sum] = "646fcd3df81cc5eb8e883d9c948a34e071919ad482c7cb032edd5257378a3c4a"

S = "${WORKDIR}/arts-${PV}"

inherit autotools native
