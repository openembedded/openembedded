DESCRIPTION = "LXDE Session"
SECTION = "x11"
DEPENDS = "gtk+"
PR = "r1"

SRC_URI = "${SOURCEFORGE_MIRROR}/lxde/${PN}-${PV}.tar.gz"

inherit autotools

FILES_${PN} += "${datadir}/lxsession"

SRC_URI[md5sum] = "909c3b0f4c6e4855f64dfbb47467c0b3"
SRC_URI[sha256sum] = "3754ee460942bfde94e6a7fdf20c337a1b6a069cea6972d0c33a115db828dba4"
