DESCRIPTION = "DBus and HAL convenience wrappers for EFL"
DEPENDS = "dbus ecore"
LICENSE = "MIT BSD"
PV = "0.1.0.042+cvs${SRCDATE}"
PR = "r2"

inherit efl_library

SRC_URI = "${E_CVS};module=e17/libs/e_dbus"
S = "${WORKDIR}/e_dbus"

PACKAGES =+ "${PN}-enotify ${PN}-edbus ${PN}-enm ${PN}-ehal"
FILES_${PN}-enotify = "${libdir}/libenotify.so.*"
FILES_${PN}-edbus = "${libdir}/libedbus.so.*"
FILES_${PN}-enm = "${libdir}/libenm.so.*"
FILES_${PN}-ehal = "${libdir}/libehal.so.*"
