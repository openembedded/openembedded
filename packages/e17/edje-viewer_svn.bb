DESCRIPTION = "Edje_Viewer is just that."
DEPENDS = "etk"
LICENSE = "MIT BSD"
PV = "0.0.0+svnr${SRCREV}"
PR = "r1"

inherit e

SRC_URI = "svn://svn.enlightenment.org/svn/e/trunk;module=edje_viewer;proto=http \
           file://no-minimal-size.patch;patch=1"
S = "${WORKDIR}/edje_viewer"

FILES_${PN} = "${bindir}/* ${libdir}/* ${datadir} ${sysconfdir} ${sbindir}"
