SECTION = "unknown"
LICENSE = "GPLv2"
inherit autotools gtk-icon-cache

# Override RDEPENDS_${PN} = hicolor-icon-theme from gtk-icon-cache
RDEPENDS_${PN} = ""
RDEPENDS_${PN} = ""
PR = "r2"

SRC_URI = "http://icon-theme.freedesktop.org/releases/${P}.tar.gz"

PACKAGE_ARCH = "all"

FILES_${PN} += "${datadir}/icons"

SRC_URI[md5sum] = "5cf5527e803a554f43319ee53c771e0b"
SRC_URI[sha256sum] = "44eb1f158a9b2a92cd626541a24c44387162b3d792e4b238c84e6f3d8ed1dd9a"
