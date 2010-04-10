DESCRIPTION = "LXDE Common Files"
SECTION = "x11"
DEPENDS = ""

SRC_URI = "${SOURCEFORGE_MIRROR}/lxde/${PN}-${PV}.tar.bz2"

inherit autotools update-alternatives

PACKAGES += "lxde-icon-theme"
FILES_${PN} += "${datadir}/lxde/ ${datadir}/lxpanel ${datadir}/xsessions"
FILES_lxde-icon-theme = "${datadir}/icons"

ALTERNATIVE_PATH = "${bindir}/startlxde"
ALTERNATIVE_NAME = "x-window-manager"
ALTERNATIVE_LINK = "${bindir}/x-window-manager"
ALTERNATIVE_PRIORITY = "15"

SRC_URI[md5sum] = "f30eee998071ace04e7be33aa8ac6a5b"
SRC_URI[sha256sum] = "bd9e9a368affb5565b50b0b79a3d04138d10f19d55ab13c8ea3ba3e32790876e"
