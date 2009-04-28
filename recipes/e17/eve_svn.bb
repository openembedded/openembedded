DESCRIPTION = " Enlightenment webbrowser"
LICENSE = "GPL"
DEPENDS = "webkit-efl evas ecore edje"
PV="0.0.1"
PR="r1"

inherit e

SRC_URI = "svn://svn.enlightenment.org/svn/e/trunk/PROTO;module=eve;proto=http"
S = "${WORKDIR}/eve"

FILES_${PN} += "${datadir}"
