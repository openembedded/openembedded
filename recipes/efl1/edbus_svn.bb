DESCRIPTION = "DBus and HAL convenience wrappers for EFL"
DEPENDS = "dbus ecore"
LICENSE = "MIT BSD"
PV = "0.5.0.060+svnr${SRCPV}"
PR = "r1"

inherit efl

SRC_URI = "svn://svn.enlightenment.org/svn/e/trunk;module=e_dbus;proto=http"
S = "${WORKDIR}/e_dbus"

EXTRA_OECONF = "--enable-build-test-gui"

PACKAGES =+ "${PN}-enotify ${PN}-edbus ${PN}-enm ${PN}-ehal ${PN}-test-gui"
FILES_${PN}-enotify = "${libdir}/libenotify.so.*"
FILES_${PN}-edbus = "${libdir}/libedbus.so.*"
FILES_${PN}-enm = "${libdir}/libenm.so.*"
FILES_${PN}-ehal = "${libdir}/libehal.so.*"
FILES_${PN}-test-gui = "${bindir}/e_dbus_hal"
