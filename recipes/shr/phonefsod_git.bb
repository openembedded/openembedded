DESCRIPTION = "SHR Phone FSO Daemon"
HOMEPAGE = "http://shr-project.org/"
LICENSE = "GPL"
SECTION = "x11/applications"
DEPENDS += " dbus-glib libframeworkd-glib sqlite3 shr-specs"
PV = "0.0.0+gitr${SRCREV}"
PR = "r4"

SRC_URI = "git://git.shr-project.org/repo/phonefsod.git;protocol=http;branch=master"
S = "${WORKDIR}/git"

inherit autotools update-rc.d

INITSCRIPT_NAME = "phonefsod"
INITSCRIPT_PARAMS = "defaults 75"

EXTRA_OECONF = "\
	SPECS_PATH=${STAGING_DATADIR}/shr-specs \
"

CONFFILES_${PN} = "${sysconfdir}/phonefsod.conf"


