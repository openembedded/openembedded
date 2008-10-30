DESCRIPTION = "An Elementary based Alarm app"
LICENSE = "GPL"
DEPENDS = "elementary"
RDEPENDS = "waker"
PV = "0.0.0+svnr${SRCREV}"
PR = "r0.21"

inherit e

SRC_URI = "svn://svn.enlightenment.org/svn/e/trunk/TMP/st;module=alarm;proto=http"
S = "${WORKDIR}/alarm"

PACKAGES="${PN}-dbg ${PN}"

FILES_${PN} += "${bindir}/*"
FILES_${PN} += "${datadir}/${PN}"
FILES_${PN} += "${datadir}/icons/*"
FILES_${PN} += "${datadir}/applications/*"
FILES_${PN} += "${datadir}/${PN}/sounds/*"
