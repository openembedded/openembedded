
SRC_URI = "git://git.gnome.org/${PN}.git;protocol=git"
SRCREV="18bce68c8e54032f2d7e78a8484ac892ba3ebd5a"
PV = "0.0+gitr${SRCPV}"
PR = "r1"
PE = "1"

DEPENDS = "libsoup-2.4"

S = "${WORKDIR}/git"

inherit autotools

do_configure_prepend () {
	echo "EXTRA_DIST=" > ${S}/gtk-doc.make
}
