DESCRIPTION = "FUSE Python bindings."
SECTION = "devel/python"
LICENSE = "GPLv2"
DEPENDS = "fuse"
SRCNAME = "fuse-python"
PR = "ml0"

SRC_URI = "${SOURCEFORGE_MIRROR}/fuse/${SRCNAME}-${PV}.tar.gz"
S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit distutils

FILES_${PN}-dbg += "${libdir}/python*/site-packages/fuseparts/.debu*"
