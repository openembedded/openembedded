DESCRIPTION = "SHR Phone FSO Daemon"
HOMEPAGE = "http://shr-project.org/"
LICENSE = "GPL"
SECTION = "x11/applications"
DEPENDS += " libfso-glib libshr-glib sqlite3 shr-specs libfsoframework"
SRCREV = "374548a6d9d53f4b3d26b70cbb5ab7257e6ce26d"
PV = "0.0.0+gitr${SRCPV}"
PR = "r5"

SRC_URI = "git://git.shr-project.org/repo/phonefsod.git;protocol=http;branch=master"
S = "${WORKDIR}/git"

inherit autotools update-rc.d

INITSCRIPT_NAME = "phonefsod"
INITSCRIPT_PARAMS = "defaults 75"

CONFFILES_${PN} = "${sysconfdir}/phonefsod.conf"


