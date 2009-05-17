require vala.inc
inherit native

DEPENDS = "glib-2.0-native"
# vala from git always needs the latest released version to compile itself
DEPENDS += "vala-bootstrap-native"
PV = "0.7.2-fso0-gitr${SRCREV}"

export VALAC = "${STAGING_BINDIR_NATIVE}/valac"

SRC_URI = "\
  ${FREESMARTPHONE_GIT}/vala-lang;protocol=git;branch=pending-upstream-move \
"         
S = "${WORKDIR}/git"
