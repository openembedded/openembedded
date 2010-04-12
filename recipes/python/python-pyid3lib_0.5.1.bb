DESCRIPTION = "A Python Wrapper for libid3."
SECTION = "devel/python"
PRIORITY = "optional"
LICENSE = "LGPL"
DEPENDS = "id3lib"
SRCNAME = "pyid3lib"
PR = "r2"

SRC_URI = "\
  ${SOURCEFORGE_MIRROR}/pyid3lib/${SRCNAME}-${PV}.tar.bz2\
  file://gcc4-fix.patch;patch=1 \
"
S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit distutils

SRC_URI[md5sum] = "49818a591430e08057c27a11e4c40aef"
SRC_URI[sha256sum] = "2a7bdd52c24ed0e70e4a2d82c697214c4ab5a70f94ea9e7934df15ca202d1169"
