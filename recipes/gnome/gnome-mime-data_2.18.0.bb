LICENSE = "GPLv2 GPLv2+"
inherit gnome

DEPENDS += "shared-mime-info intltool-native"
RDEPENDS_${PN} = "shared-mime-info"
PR = "r2"

FILES_${PN}-dev += "${datadir}/pkgconfig/*.pc"

SRC_URI[archive.md5sum] = "541858188f80090d12a33b5a7c34d42c"
SRC_URI[archive.sha256sum] = "37196b5b37085bbcd45c338c36e26898fe35dd5975295f69f48028b1e8436fd7"
