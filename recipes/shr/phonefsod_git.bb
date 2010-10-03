DESCRIPTION = "SHR Phone FSO Daemon"
HOMEPAGE = "http://shr-project.org/"
LICENSE = "GPL"
SECTION = "x11/applications"
DEPENDS += " libfso-glib dbus-glib libframeworkd-glib sqlite3 shr-specs libfsoframework"
SRCREV = "d910e1c3ca270409325f0fc807245a14c84c35f7"
PV = "0.0.0+gitr${SRCPV}"
PR = "r5"

SRC_URI = "git://git.shr-project.org/repo/phonefsod.git;protocol=http;branch=master"
S = "${WORKDIR}/git"

inherit autotools update-rc.d

INITSCRIPT_NAME = "phonefsod"
INITSCRIPT_PARAMS = "defaults 75"

EXTRA_OECONF = "\
	SPECS_PATH=${STAGING_DATADIR}/shr-specs \
"

CONFFILES_${PN} = "${sysconfdir}/phonefsod.conf"


