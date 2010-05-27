DESCRIPTION = "freesmartphone.org API glib wrapper"
LICENSE = "LGPL"
SECTION = "devel"
DEPENDS = "dbus-glib"
SRCREV = "43f25d7343145111e70dceaa610decab84366cbb"
PV = "0.0.1+gitr${SRCPV}"
PE = "1"
PR = "r0"

SRC_URI = "${FREESMARTPHONE_GIT}/libframeworkd-glib.git;protocol=git;branch=master"
S = "${WORKDIR}/git"

inherit autotools pkgconfig

do_stage() {
	autotools_stage_all
}

