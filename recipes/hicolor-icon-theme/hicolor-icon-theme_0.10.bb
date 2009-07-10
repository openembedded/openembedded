SECTION = "unknown"
LICENSE = "GPL"
inherit autotools gtk-icon-cache

# Override RDEPENDS = hicolor-icon-theme from gtk-icon-cache
RDEPENDS = ""
RDEPENDS_${PN} = ""

SRC_URI = "http://icon-theme.freedesktop.org/releases/${P}.tar.gz"

PACKAGE_ARCH = "all"

FILES_${PN} += "${datadir}/icons"
