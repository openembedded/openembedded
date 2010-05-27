DESCRIPTION = "SHR Phone FSO Daemon"
HOMEPAGE = "http://shr-project.org/"
LICENSE = "GPL"
SECTION = "x11/applications"
DEPENDS += " dbus-glib libframeworkd-glib sqlite3 shr-specs"
SRCREV = "c01f2eb0eb79d5d5581ab35f2dbd1c3b3979439b"
PV = "0.0.0+gitr${SRCPV}"
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


