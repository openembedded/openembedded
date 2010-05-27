DESCRIPTION = "SHR Phone UI Daemon"
HOMEPAGE = "http://shr-project.org/"
LICENSE = "GPL"
SECTION = "x11/applications"
DEPENDS += " dbus-glib libframeworkd-glib libphone-ui sqlite3 shr-specs"
SRCREV = "ba69e4ed25e10cf47a3d9a9b69fcbda58a5c87cd"
PV = "0.0.0+gitr${SRCPV}"
PR = "r6"

RREPLACES_${PN} = "shr-today"
RCONFLICTS_${PN} = "shr-today"

SRC_URI = "git://git.shr-project.org/repo/phoneuid.git;protocol=http;branch=master"
S = "${WORKDIR}/git"

inherit autotools

EXTRA_OECONF = "\
       SPECS_PATH=${STAGING_DATADIR}/shr-specs \
"


FILES_${PN} += "${datadir}"

CONFFILES_${PN} = "${sysconfdir}/phoneuid.conf"

