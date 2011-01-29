require python-efl.inc
SRCREV = "${EFL_SRCREV}"
DEPENDS += "edbus python-dbus"
RDEPENDS_${PN} += "python-dbus"
SRCNAME = "python-e_dbus"
