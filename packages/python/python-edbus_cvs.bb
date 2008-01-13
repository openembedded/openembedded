require python-efl.inc
# broken until someone adds dbus 1.1.x
DEPENDS += "edbus dbus-1.1"

PR = "r0"

SRC_URI = "${E_CVS};module=e17/proto/python-efl/python-e_dbus"
S = "${WORKDIR}/python-e_dbus"

