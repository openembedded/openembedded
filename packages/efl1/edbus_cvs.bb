DESCRIPTION = "DBus and HAL convenience wrappers for EFL"
DEPENDS = "dbus ecore"
LICENSE = "MIT BSD"
PV = "0.5.0.043+cvs${SRCDATE}"
PR = "r1"

inherit efl

SRC_URI = "\
  ${E_CVS};module=e17/libs/e_dbus \
  http://people.openmoko.org/stefan/e_nm-big-hack.patch;patch=1;pnum=1;mindate=20080330;maxdate=20080501 \
"
S = "${WORKDIR}/e_dbus"

EXTRA_OECONF = "--enable-build-test-gui"

PACKAGES =+ "${PN}-enotify ${PN}-edbus ${PN}-enm ${PN}-ehal ${PN}-test-gui"
FILES_${PN}-enotify = "${libdir}/libenotify.so.*"
FILES_${PN}-edbus = "${libdir}/libedbus.so.*"
FILES_${PN}-enm = "${libdir}/libenm.so.*"
FILES_${PN}-ehal = "${libdir}/libehal.so.*"
FILES_${PN}-test-gui = "${bindir}/e_dbus_hal"
