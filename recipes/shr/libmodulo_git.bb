DESCRIPTION = "Modulo is a lightweight component container that supports Inversion Of Control, also commonly called Dependency Injection"
SECTION = "libs"
SRCREV = "7d2f657d248bd86377e66c329aa6826459d406da"
PV = "0.0.1+gitr${SRCREV}"
PR = "r1"

inherit autotools autotools_stage pkgconfig vala

DEPENDS = "glib-2.0 dbus-glib libxml2 libgee"

SRC_URI = "git://git.shr-project.org/repo/libmodulo.git;protocol=http;branch=master"
S = "${WORKDIR}/git"

LEAD_SONAME = "libmodulo.so.0"
