DESCRIPTION = "Desktop environment and phone stack GUI for SHR"
HOMEPAGE = "http://gitorious.org/mokosuite2"
AUTHOR = "Daniele Ricci"
LICENSE = "GPLv3"
DEPENDS = "mokowm elementary libfakekey libfreesmartphone-glib libphone-utils eggdbus glib-2.0 dbus-glib alsa-lib db sqlite3 vala-native"
SECTION = "misc/utils"

PV = "1.0.99+gitr${SRCPV}"
PR = "r2"
SRCREV = "d884a48ca633a9ddc4ed650232fc41e86328b0ab"

SRC_URI = "git://gitorious.org/mokosuite2/appbunch.git;protocol=git"
S = "${WORKDIR}/git"

PARALLEL_MAKE = ""

CFLAGS += "-DOPENMOKO"
EXTRA_OECONF = " --enable-contactsdb-sqlite --enable-settings-config --with-edje-cc=${STAGING_BINDIR_NATIVE}/edje_cc"
FILES_${PN} += "${datadir}/mokosuite ${sysconfdir}/dbus-1 ${sysconfdir}/X11 ${sysconfdir}/mokosuite.conf {$datadir}/applications"
CONFFILES_${PN} = "${sysconfdir}/mokosuite.conf"

inherit pkgconfig autotools
