DESCRIPTION = "Desktop environment and phone stack GUI for SHR"
HOMEPAGE = "http://wiki.openmoko.org/"
AUTHOR = "Daniele Ricci"
LICENSE = "GPLv3"
DEPENDS = "elementary libframeworkd-glib libphone-utils eggdbus glib-2.0 dbus-glib alsa-lib db sqlite3"
SECTION = "misc/utils"

PV = "1.0+svnr${SRCPV}"
SRCREV = "454"

SRC_URI = "svn://svn.casaricci.it/openmoko/trunk;module=mokosuite;proto=svn"
S = "${WORKDIR}/mokosuite"

PARALLEL_MAKE = ""

CFLAGS += "-DOPENMOKO"
EXTRA_OECONF = " --enable-callsdb-sqlite --enable-contactsdb-sqlite --with-edje-cc=${STAGING_BINDIR_NATIVE}/edje_cc"
FILES_${PN} += "${datadir}/mokosuite ${sysconfdir}/dbus-1 ${sysconfdir}/X11 ${sysconfdir}/mokosuite.conf {$datadir}/applications"
CONFFILES_${PN} = "${sysconfdir}/mokosuite.conf"

inherit pkgconfig autotools

ALTERNATIVE_PATH = "${bindir}/mokosession"
ALTERNATIVE_NAME = "x-window-manager"
ALTERNATIVE_LINK = "${bindir}/x-window-manager"
ALTERNATIVE_PRIORITY = "20"
