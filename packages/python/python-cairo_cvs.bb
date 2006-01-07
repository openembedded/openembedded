DESCRIPTION = "Python Cairo Bindings"
SECTION = "devel/python"
PRIORITY = "optional"
MAINTAINER = "Sandino 'Tigrux' Flores <tigrux@ximian.com>"
DEPENDS = "python-pygtk cairo"
SRCNAME = "pycairo"
PV = "0.0+cvs${SRCDATE}"
LICENSE = "LGPL MPL"
inherit autotools

SRC_URI = "cvs://anoncvs@cvs.cairographics.org/cvs/cairo;module=pycairo"
S = "${WORKDIR}/${SRCNAME}"

FILES_${PN} = "${libdir}/${PYTHON_DIR}/"
