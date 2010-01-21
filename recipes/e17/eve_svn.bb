DESCRIPTION = " Enlightenment webbrowser"
LICENSE = "GPL"
DEPENDS = "webkit-efl evas ecore edje"
PV = "0.0.1+svnr${SRCPV}"
PR = "r4"

LDFLAGS += "-lstdc++"

inherit e

SRC_URI = "svn://svn.enlightenment.org/svn/e/trunk/PROTO;module=eve;proto=http \
"

S = "${WORKDIR}/eve"

RDEPENDS_${PN} = "${PN}-themes"


