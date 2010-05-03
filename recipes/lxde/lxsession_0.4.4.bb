DESCRIPTION = "LXDE Session"
SECTION = "x11"
DEPENDS = "gtk+"

SRC_URI = "${SOURCEFORGE_MIRROR}/lxde/${PN}-${PV}.tar.gz"

SRC_URI[md5sum] = "9d433e1219eac07862c0d725ab58444f"
SRC_URI[sha256sum] = "5d9304697fbc872f34e60728d046b10a0f41322099be828bae461b6b9ab617f8"

inherit autotools

RPROVIDES_${PN} = "lxsession-lite"
FILES_${PN} += "${datadir}/lxsession"

