DESCRIPTION = "LXDE Panel"
SECTION = "x11"
DEPENDS = ""

SRC_URI = "${SOURCEFORGE_MIRROR}/lxde/${PN}-${PV}.tar.gz"

SRC_URI[md5sum] = "cee3181dd22088f3db0e99ffbedc986d"
SRC_URI[sha256sum] = "c665d804ac25a6c3f2ee76d0ebdc6cc8c5c37895aa44f5ef88c4024e98cbdf4d"

inherit autotools

FILES_${PN} += "${datadir}/desktop-directories/"

