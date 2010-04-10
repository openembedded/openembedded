SECTION = "unknown"
LICENSE = "GPL"
inherit autotools gtk-icon-cache

# Override RDEPENDS = hicolor-icon-theme from gtk-icon-cache
RDEPENDS = ""
RDEPENDS_${PN} = ""

SRC_URI = "http://icon-theme.freedesktop.org/releases/${P}.tar.gz"

PACKAGE_ARCH = "all"

FILES_${PN} += "${datadir}/icons"

SRC_URI[md5sum] = "3534f7b8e59785c7d5bfa923e85510a7"
SRC_URI[sha256sum] = "9d73af8f61240fbb3c522321582cd693c5b81ef344067a3949f0aa624610adee"
