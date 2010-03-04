DESCRIPTION = "phone-utils library"
SECTION = "libs"
SRCREV = "3eb7242866543a266bd43a048d05b1a674ce94cf"
PV = "0.0.2+gitr${SRCREV}"
PR = "r2"

DEPENDS="glib-2.0"

inherit pkgconfig autotools autotools_stage

CONFFILES_${PN} = "${sysconfdir}/phone-utils.conf"
SRC_URI = "git://git.shr-project.org/repo/libphone-utils.git;protocol=http;branch=master"
S="${WORKDIR}/git"
