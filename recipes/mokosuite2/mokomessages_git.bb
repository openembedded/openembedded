DESCRIPTION = "Desktop environment and phone stack GUI for SHR - messages application"
HOMEPAGE = "http://gitorious.org/mokosuite2"
AUTHOR = "Daniele Ricci"
LICENSE = "GPLv3"
DEPENDS = "libmokosuite libfreesmartphone-glib libphone-utils glib-2.0 dbus-glib elementary edje-native"
SECTION = "misc/utils"

PV = "1.0.99+gitr${SRCPV}"
SRCREV = "9d3f51f73d7ea9febcf59525ec6444b322238c7e"

SRC_URI = "git://gitorious.org/mokosuite2/mokomessages.git;protocol=git"
S = "${WORKDIR}/git"

PARALLEL_MAKE = ""

EXTRA_OECONF = " --with-edje-cc=${STAGING_BINDIR_NATIVE}/edje_cc --enable-debug"
FILES_${PN} += "${datadir}/mokosuite/messages"

inherit autotools

do_install_append() {
    ln -s themes/gry.edj ${D}${datadir}/mokosuite/messages/theme.edj
}
