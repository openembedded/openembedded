DESCRIPTION = "PyODE is a set of open-source Python bindings for The Open Dynamics Engine, \
an open-source physics engine. PyODE also includes an XODE parser."
SECTION = "devel/python"
PRIORITY = "optional"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"
LICENSE = "LGPL"
SRCNAME = "PyODE"

SRC_URI = "${SOURCEFORGE_MIRROR}/pyode/${SRCNAME}-${PV}.tar.bz2"
S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit distutils

do_configure_prepend() {
	ln -s ${STAGING_LIBDIR}/.. ../ode
}

