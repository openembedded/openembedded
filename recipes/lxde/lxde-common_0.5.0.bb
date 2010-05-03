DESCRIPTION = "LXDE Common Files"
SECTION = "x11"
DEPENDS = ""

SRC_URI = "${SOURCEFORGE_MIRROR}/lxde/${PN}-${PV}.tar.gz"

SRC_URI[md5sum] = "23606ab3d6e1039386d62a4b68b4ffc6"
SRC_URI[sha256sum] = "db427817070172be349709604944ba7024ac56e5c87f687b7c3f97be58a1e80a"

inherit autotools update-alternatives

PACKAGES += "lxde-icon-theme"
FILES_${PN} += "${datadir}/lxde/ ${datadir}/lxpanel ${datadir}/xsessions"
FILES_lxde-icon-theme = "${datadir}/icons"

ALTERNATIVE_PATH = "${bindir}/startlxde"
ALTERNATIVE_NAME = "x-window-manager"
ALTERNATIVE_LINK = "${bindir}/x-window-manager"
ALTERNATIVE_PRIORITY = "15"

