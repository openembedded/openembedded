require python-efl.inc
DEPENDS += "edbus dbus"

PR = "r2"

SRC_URI = "${E_CVS};module=e17/proto/python-efl/python-e_dbus"
S = "${WORKDIR}/python-e_dbus"

