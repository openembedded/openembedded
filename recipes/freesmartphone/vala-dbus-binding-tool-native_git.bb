DESCRIPTION = "Vala DBus Binding Tool"
SECTION = "console"
LICENSE = "GPLv2"
DEPENDS = "vala-native intltool-native libxml2-native"
PV = "0.1.0+gitr${SRCREV}"

SRC_URI = "${FREESMARTPHONE_GIT}/vala-dbus-binding-tool.git;protocol=git;branch=master"
S = "${WORKDIR}/git"

inherit autotools native autotools_stage

