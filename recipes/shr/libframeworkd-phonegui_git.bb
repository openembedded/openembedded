DESCRIPTION = "Frameworkd phonegui library"
SECTION = "libs"
PV = "0.0.2+gitr${SRCPV}"
PR = "r9"

DEPENDS="glib-2.0 dbus-glib libframeworkd-glib libphone-utils"

inherit shr pkgconfig autotools autotools_stage

CONFFILES_${PN} = "${sysconfdir}/frameworkd-phonegui.conf"
