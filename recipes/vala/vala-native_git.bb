require vala.inc
inherit native

DEPENDS = "glib-2.0-native"
# vala from git always needs the latest released version to compile itself
PV = "0.7.0-fso1-gitr${SRCREV}"

SRC_URI = "\
  ${FREESMARTPHONE_GIT}/vala-lang;protocol=git;branch=pending-upstream-move \
"         
S = "${WORKDIR}/git"
