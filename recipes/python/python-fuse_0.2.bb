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

SRC_URI[md5sum] = "68be744e71a42cd8a92905a49f346278"
SRC_URI[sha256sum] = "89f3e9ac096759e10b6292632216c9653d7e35c2c99847267173d94afdf85b92"
