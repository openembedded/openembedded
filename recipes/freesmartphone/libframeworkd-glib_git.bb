DESCRIPTION = "freesmartphone.org API glib wrapper"
LICENSE = "LGPL"
SECTION = "devel"
DEPENDS = "dbus-glib"
SRCREV = "322ad983ee811308d9a8dd6df02cf02ab2c0825f"
PV = "0.0.1+gitr${SRCPV}"
PE = "1"
PR = "r0"

SRC_URI = "${FREESMARTPHONE_GIT}/libframeworkd-glib.git;protocol=git;branch=master"
S = "${WORKDIR}/git"

inherit autotools pkgconfig

do_stage() {
	autotools_stage_all
}

