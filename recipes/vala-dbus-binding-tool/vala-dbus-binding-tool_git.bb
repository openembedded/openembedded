require vala-dbus-binding-tool.inc
PV = "0.1.3+gitr${SRCREV}"

DEFAULT_PREFERENCE = "-1"

SRC_URI = "${FREESMARTPHONE_GIT}/vala-dbus-binding-tool.git;protocol=git;branch=master"
S = "${WORKDIR}/git"
