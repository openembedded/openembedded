require vala_0.5.7.bb
# vala from git always needs the latest released version to compile itself
DEPENDS = "vala-native"

SRCREV = "633493367757a8e5f663c69c975bf525ab8a6d53"
PV := "0.5.7+0.5.8pre01-git${SRCREV}"

DEFAULT_PREFERENCE = "-1"

SRC_URI = "${GNOME_GIT}/vala;protocol=git;branch=master"
S = "${WORKDIR}/git"

inherit native
DEPENDS = "glib-2.0-native"
