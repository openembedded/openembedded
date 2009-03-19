require vala_0.5.7.bb
# vala from git always needs the latest released version to compile itself
DEPENDS = "vala-native"

SRCREV = "e7462e3ed00b75c16c11c27f6d8a640c7f35fafc"
PV := "0.5.7+0.5.8pre02-gitr${SRCREV}"

DEFAULT_PREFERENCE = "-1"

SRC_URI = "\
  ${FREESMARTPHONE_GIT}/vala;protocol=git;branch=master \
  file://static-dbus-methods.patch;patch=1 \
"         
S = "${WORKDIR}/git"

inherit native
DEPENDS = "glib-2.0-native"
