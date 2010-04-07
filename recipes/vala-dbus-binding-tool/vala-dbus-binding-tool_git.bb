require vala-dbus-binding-tool.inc
SRCREV = "0dda9a5d7f895d67c6a778f559e929ace229e42b"
PV = "0.1.3+gitr${SRCREV}"

DEFAULT_PREFERENCE = "-1"

SRC_URI = "${FREESMARTPHONE_GIT}/vala-dbus-binding-tool.git;protocol=git;branch=master"
S = "${WORKDIR}/git"
