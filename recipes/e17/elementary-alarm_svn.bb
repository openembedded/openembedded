DESCRIPTION = "An Elementary based Alarm app"
LICENSE = "GPL"
DEPENDS = "elementary"
SECTION = "x11"
PV = "0.0.0+svnr${SRCPV}"
PR = "r1"
SRCREV = "${EFL_SRCREV}"

inherit e

SRC_URI = "svn://svn.enlightenment.org/svn/e/trunk/TMP/st;module=elementary-alarm;proto=http"
S = "${WORKDIR}/elementary-alarm"

RDEPENDS = "waker"
FILES_${PN} += "${bindir}/*"
FILES_${PN} += "${datadir}/${PN}"
FILES_${PN} += "${datadir}/icons/*"
FILES_${PN} += "${datadir}/applications/*"
FILES_${PN} += "${datadir}/${PN}/sounds/*"
