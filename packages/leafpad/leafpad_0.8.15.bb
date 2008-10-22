DESCRIPTION = "GTK+ based simple text editor"
DESCRIPTION_${PN}-icons = "Extra icon files for leafpad text editor"
HOMEPAGE = "http://tarot.freeshell.org/leafpad"
AUTHOR = "Tarot Osuji <tarot@sdf.lonestar.org>"
SECTION = "x11/applications"
LICENSE = "GPLv2"
DEPENDS = "gtk+ intltool-native"
SRC_URI = "http://savannah.nongnu.org/download/${PN}/${PN}-${PV}.tar.gz"

PR = "r1"

inherit autotools pkgconfig

EXTRA_OECONF = " --enable-chooser --enable-emacs --disable-print"

PACKAGES =+ "${PN}-icons"

FILES_${PN}-icons = "${datadir}/icons"
FILES_${PN} += "${datadir}/applications ${datadir}/pixmaps ${datadir}/icons"
