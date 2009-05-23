DESCRIPTION = "Fusil is a Python library used to write fuzzing programs."
HOMEPAGE = "http://fusil.hachoir.org/"
SECTION = "devel/python"
LICENSE = "GPLv2"
SRCNAME = "configobj"

SRC_URI = "http://www.voidspace.org.uk/cgi-bin/voidspace/downman.py?file=configobj-${PV}.zip"
S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools

DEPENDS_${PN} = "python \
"
DISTUTILS_INSTALL_ARGS = "--root=${D} \
    --prefix=${prefix} \
    --install-data=${datadir}"

