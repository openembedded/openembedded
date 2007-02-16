DESCRIPTION = "The OpenMoko Dialer"
SECTION = "openmoko/applications"
PV = "0.0.1+svn${SRCDATE}"

inherit openmoko

DEPENDS += " eds-dbus libgsmd"


