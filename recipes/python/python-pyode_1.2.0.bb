DESCRIPTION = "PyODE is a set of open-source Python bindings for The Open Dynamics Engine, \
an open-source physics engine. PyODE also includes an XODE parser."
SECTION = "devel/python"
PRIORITY = "optional"
LICENSE = "LGPL"
DEPENDS = "ode"
SRCNAME = "PyODE"
PR = "r1"

SRC_URI = "${SOURCEFORGE_MIRROR}/pyode/${SRCNAME}-${PV}.tar.bz2 \
           file://install.patch;patch=1"
S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit distutils

do_configure_prepend() {
	ln -s ${STAGING_LIBDIR}/.. ../ode
}


SRC_URI[md5sum] = "ab72f3acc635371fd454978e5a97591c"
SRC_URI[sha256sum] = "117c8f06012e0c0004e69527580a56fac3d814da1051ec1aa73d97d16b60279b"
