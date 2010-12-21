DESCRIPTION = "Desktop environment and phone stack GUI for SHR - dock panel and idle screen"
HOMEPAGE = "http://gitorious.org/mokosuite2"
AUTHOR = "Daniele Ricci"
LICENSE = "GPLv3"
DEPENDS = "libmokosuite libfreesmartphone-glib glib-2.0 dbus-glib elementary vala-native edje-native"
SECTION = "misc/utils"

PV = "1.0.99+gitr${SRCPV}"
SRCREV = "a7140f6aba2de7d7ec69349c89b647c391dcc832"

SRC_URI = "git://gitorious.org/mokosuite2/mokopanel.git;protocol=git"
S = "${WORKDIR}/git"

PARALLEL_MAKE = ""

EXTRA_OECONF = " --with-edje-cc=${STAGING_BINDIR_NATIVE}/edje_cc --enable-debug"
FILES_${PN} += "${datadir}/mokosuite/panel"

inherit autotools

do_install_append() {
    ln -s themes/gry.edj ${D}${datadir}/mokosuite/panel/theme.edj
}
