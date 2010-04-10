LICENSE = "GPLv2"
HOMEPAGE = "http://www.gpleda.org/"
PR = "r1"

DEPENDS = "gtk+ libgeda"

SRC_URI = "http://geda.seul.org/release/v1.4/${PV}/${P}.tar.gz"

inherit autotools pkgconfig

SRC_URI[md5sum] = "923fe9d9cc843b5eb7b26c91ad0ef2d4"
SRC_URI[sha256sum] = "38a7c6d39a8b298aa1baeadaf7a174ed2ae6397ef227f19cb0bee22757b6e553"
