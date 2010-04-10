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

SRC_URI[md5sum] = "f3570c052f4987f4122cd48d2c629f64"
SRC_URI[sha256sum] = "f294a7894efc8eee0c0c4238f41cc97492c61dd3dcceae4fcf555e31e841d86a"
