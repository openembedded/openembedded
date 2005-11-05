SECTION = "unknown"
LICENSE = "GPL"
inherit gnome

SRC_URI = "http://freedesktop.org/software/icon-theme/releases/hicolor-icon-theme-${PV}.tar.gz"

FILES_${PN} += "${datadir}/icons"
