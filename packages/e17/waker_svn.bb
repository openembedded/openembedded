DESCRIPTION = "An EFL base at/alarm wakeup daemon"
LICENSE = "LGPL"
DEPENDS = "ecore edbus"
PV = "0.0.0+svnr${SRCREV}"
PR = "r0.20"

inherit efl

SRC_URI = "svn://svn.enlightenment.org/svn/e/trunk/TMP/st;module=waker;proto=http"
S = "${WORKDIR}/waker"

FILES_${PN} += "${bindir}/* ${libdir}/lib*.so.*"
FILES_${PN} += "/etc/X11/Xsession.d/80x-enlightenment-wakerd"
