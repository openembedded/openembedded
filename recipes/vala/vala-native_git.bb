require vala.inc
inherit native

DEPENDS = "glib-2.0-native"
# vala from git always needs the latest released version to compile itself
DEPENDS += "vala-bootstrap-native"
PV = "0.6.0-fso1-gitr${SRCREV}"

SRC_URI = "\
  ${FREESMARTPHONE_GIT}/vala-lang;protocol=git;branch=mickey/0.6/posix \
  file://static-dbus-methods.patch;patch=1 \
"         
S = "${WORKDIR}/git"
