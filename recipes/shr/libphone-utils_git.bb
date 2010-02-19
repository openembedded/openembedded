DESCRIPTION = "phone-utils library"
SECTION = "libs"
SRCREV = "8a7c719e0c3f1f8c10f77f17422da02d7177f0dd"
PV = "0.0.2+gitr${SRCREV}"
PR = "r2"

DEPENDS="glib-2.0"

inherit pkgconfig autotools autotools_stage

CONFFILES_${PN} = "${sysconfdir}/phone-utils.conf"
SRC_URI = "git://git.shr-project.org/repo/libphone-utils.git;protocol=http;branch=master"
S="${WORKDIR}/git"
