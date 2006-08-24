SECTION = "unknown"
LICENSE = "GPL"
inherit gnome

SRC_URI = "http://icon-theme.freedesktop.org/releases/${P}.tar.gz"

FILES_${PN} += "${datadir}/icons"
