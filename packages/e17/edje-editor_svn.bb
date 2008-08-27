DESCRIPTION = "Edje-Editor is just that."
LICENSE = "MIT BSD"
DEPENDS = "etk"
PV = "0.0.0+svnr${SRCREV}"
PR = "r1"

inherit e

SRC_URI = "svn://svn.enlightenment.org/svn/e/trunk;module=edje_editor;proto=http"
S = "${WORKDIR}/edje_editor"

FILES_${PN} = "${bindir}/* ${libdir}/* ${datadir} ${sysconfdir} ${sbindir}"
