DESCRIPTION = "GTK murrine"
LICENSE = "GPLv2"
SECTION = "x11/base"
DEPENDS = "gtk+ cairo"

DEFAULT_PREFERENCE = "-1"

inherit gnome gtk-binver

SRCREV = "6fd2709050cda6c14d290a9635e0bb08a804e177"
PV = "0.91.0"
PR_append = "+gitr${SRCREV}"


SRC_URI = "git://git.gnome.org/murrine;protocol=git"
S = "${WORKDIR}/git"

PACKAGES =+ "gtk-engine-murrine"
FILES_gtk-engine-murrine += "${datadir}/gtk-engines ${libdir}/gtk-2.0/*/engines/*.so"
