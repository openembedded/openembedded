DESCRIPTION = "Lightweight Python components for handling XML"
SECTION = "devel/python"
LICENSE = "Python"
HOMEPAGE = "http://effbot.org/zone/element-index.htm"
PR = "r0"

inherit distutils

SRC_URI = "http://effbot.org/media/downloads/elementtree-${PV}.zip"
S = "${WORKDIR}/elementtree-${PV}"

FILES_${PN} += "${datadir}"


