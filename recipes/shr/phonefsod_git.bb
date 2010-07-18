DESCRIPTION = "SHR Phone FSO Daemon"
HOMEPAGE = "http://shr-project.org/"
LICENSE = "GPL"
SECTION = "x11/applications"
DEPENDS += " libfso-glib dbus-glib libframeworkd-glib sqlite3 shr-specs libfsoframework"
SRCREV = "28c6005d865359aa7434ff7025295372c9d18bbc"
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


