DESCRIPTION = "An Elementary based SMS app"
LICENSE = "GPL"
DEPENDS = "ecore edbus elementary libefso"
SECTION = "x11"
PV = "0.0.0+svnr${SRCPV}"
PR = "r1"
SRCREV = "${EFL_SRCREV}"

inherit e

SRC_URI = "svn://svn.enlightenment.org/svn/e/trunk/TMP/st;module=elementary-sms;proto=http"
S = "${WORKDIR}/elementary-sms"

FILES_${PN} += "${bindir}/*"
FILES_${PN} += "${datadir}/${PN}"
FILES_${PN} += "${datadir}/icons/*"
FILES_${PN} += "${datadir}/applications/*"
