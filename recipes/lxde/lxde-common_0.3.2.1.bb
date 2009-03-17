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
