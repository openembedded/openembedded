DESCRIPTION = "The SHR Dialer"
SECTION = "x11/applications"
DEPENDS += "dbus-glib libframeworkd-glib libframeworkd-phonegui"
PV = "0.0.2+gitr${SRCPV}"
PR = "r8"

inherit shr pkgconfig autotools
