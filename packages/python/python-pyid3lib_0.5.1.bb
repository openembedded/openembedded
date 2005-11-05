DESCRIPTION = "A Python Wrapper for libid3."
SECTION = "devel/python"
PRIORITY = "optional"
MAINTAINER = "Jason Haslup <openembedded@haslup.com>"
LICENSE = "LGPL"
DEPENDS = "id3lib"
SRCNAME = "pyid3lib"

SRC_URI = "${SOURCEFORGE_MIRROR}/pyid3lib/${SRCNAME}-${PV}.tar.bz2"
S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit distutils


