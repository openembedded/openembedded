DESCRIPTION = "The Openmoko Dialer"
SECTION = "openmoko/applications"
PV = "0.0.1+svnr${SRCREV}"

inherit openmoko

DEPENDS += " eds-dbus libgsmd"


