DESCRIPTION = "Vala DBus Binding Tool"
SECTION = "console"
LICENSE = "GPLv2"
DEPENDS = "vala-native"
PV = "0.1.0+gitr${SRCREV}"
PR = "r0"

SRC_URI = "${FREESMARTPHONE_GIT}/vala-dbus-binding-tool.git;protocol=git;branch=master"
S = "${WORKDIR}/git"

inherit autotools native

do_stage() {
	install -d ${STAGING_BINDIR_NATIVE}
	install -m 0755 src/vala-dbus-binding-tool ${STAGING_BINDIR_NATIVE}/
}

