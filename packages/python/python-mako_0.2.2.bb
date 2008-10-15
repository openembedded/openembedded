DESCRIPTION = "A super-fast templating language that borrows the best ideas from the existing templating languages"
SECTION = "devel/python"
PRIORITY = "optional"
LICENSE = "MIT"
HOMEPAGE = "http://www.makotemplates.org/"
SRCNAME = "Mako"
PR = "ml0"

SRC_URI = "http://pypi.python.org/packages/source/M/Mako/Mako-${PV}.tar.gz" 
S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools
