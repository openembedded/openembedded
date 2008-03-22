require python-efl.inc
DEPENDS += "edbus python-dbus"
RDEPENDS += "python-dbus"
PV = "0.1.1+cvs${SRCDATE}"
PR = "r1"

SRC_URI = "${E_CVS};module=e17/proto/python-efl/python-e_dbus"
S = "${WORKDIR}/python-e_dbus"

