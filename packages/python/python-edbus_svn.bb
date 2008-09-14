require python-efl.inc
DEPENDS += "edbus python-dbus"
RDEPENDS += "python-dbus"
PV = "0.3.0+svnr${SRCREV}"
PR = "r0"

SRC_URI = "svn://svn.enlightenment.org/svn/e/trunk/BINDINGS/python;module=python-e_dbus;proto=http"
S = "${WORKDIR}/python-e_dbus"
