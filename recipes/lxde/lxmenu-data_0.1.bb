DESCRIPTION = "LXDE Panel"
SECTION = "x11"
DEPENDS = ""

SRC_URI = "${SOURCEFORGE_MIRROR}/lxde/${PN}-${PV}.tar.gz"

inherit autotools

FILES_${PN} += "${datadir}/desktop-directories/"

SRC_URI[md5sum] = "1c35ad4bf05cd076ce4a9bb64a246351"
SRC_URI[sha256sum] = "73e111f64d777f35b3ad2805aa39e7746c1d223ea4fa8f805e5767b595bfdfb6"
