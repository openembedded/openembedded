LICENSE = "GPL"
inherit gnome

DEPENDS += "shared-mime-info intltool-native"
RDEPENDS = "shared-mime-info"

FILES_${PN}-dev += "${datadir}/pkgconfig/*.pc"

SRC_URI[archive.md5sum] = "541858188f80090d12a33b5a7c34d42c"
SRC_URI[archive.sha256sum] = "37196b5b37085bbcd45c338c36e26898fe35dd5975295f69f48028b1e8436fd7"
