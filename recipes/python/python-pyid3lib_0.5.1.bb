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
