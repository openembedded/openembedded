DESCRIPTION = "A minimal X11 window manager for the Mokosuite"
HOMEPAGE = "http://gitorious.org/mokosuite2"
AUTHOR = "Daniele Ricci"
LICENSE = "GPLv3"
DEPENDS = "glib-2.0 ecore evas edje libfakekey"
SECTION = "x11/clients"

PV = "1.0.99+gitr${SRCPV}"
SRCREV = "823d3bfa136a534d97ddb65ec4b2c348ea46afe1"

SRC_URI = "git://gitorious.org/mokosuite2/mokowm.git;protocol=git"
S = "${WORKDIR}/git"

CFLAGS += "-DOPENMOKO"
EXTRA_OECONF = " --with-edje-cc=${STAGING_BINDIR_NATIVE}/edje_cc"
FILES_${PN} += "${datadir}/mokosuite ${sysconfdir}/X11"

inherit autotools update-alternatives

ALTERNATIVE_PATH = "${bindir}/mokosession"
ALTERNATIVE_NAME = "x-window-manager"
ALTERNATIVE_LINK = "${bindir}/x-window-manager"
ALTERNATIVE_PRIORITY = "20"
