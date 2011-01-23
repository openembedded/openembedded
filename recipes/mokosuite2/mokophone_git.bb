DESCRIPTION = "Desktop environment and phone stack GUI for SHR - phone application"
HOMEPAGE = "http://gitorious.org/mokosuite2"
AUTHOR = "Daniele Ricci"
LICENSE = "GPLv3"
DEPENDS = "libmokosuite libfreesmartphone-glib libphone-utils alsa-lib glib-2.0 dbus-glib elementary vala-native edje-native"
SECTION = "misc/utils"

PV = "1.0.99+gitr${SRCPV}"
SRCREV = "dd063c2ae6b6fbd5a94e0fc3cd1fdafa09d81c6e"

SRC_URI = "git://gitorious.org/mokosuite2/mokophone.git;protocol=git"
S = "${WORKDIR}/git"

PARALLEL_MAKE = ""

EXTRA_OECONF = " --with-edje-cc=${STAGING_BINDIR_NATIVE}/edje_cc --enable-debug"
FILES_${PN} += "${datadir}/mokosuite/phone"

inherit autotools

do_install_append() {
    ln -s themes/gry.edj ${D}${datadir}/mokosuite/phone/theme.edj
}
