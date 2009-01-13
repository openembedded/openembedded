DESCRIPTION = "LXDE Session"
SECTION = "x11"
DEPENDS = "gtk+"
PR = "r1"

SRC_URI = "${SOURCEFORGE_MIRROR}/lxde/${PN}-${PV}.tar.gz"

inherit autotools

FILES_${PN} += "${datadir}/lxsession"
