DESCRIPTION = "Modulo is a lightweight component container that supports Inversion Of Control, also commonly called Dependency Injection"
SECTION = "libs"
PV = "0.0.1+gitr${SRCREV}"
PR = "r0"

inherit autotools autotools_stage pkgconfig

DEPENDS = "vala-native glib-2.0 dbus-glib libxml2 vala"

SRC_URI = "git://git.shr-project.org/repo/libmodulo.git;protocol=http;branch=master"
S = "${WORKDIR}/git"

#LEAD_SONAME = "libmodulo.so.0"
