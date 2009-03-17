DESCRIPTION = "vte is a virtual terminal emulator"
LICENSE = "LGPL"
DEPENDS += " glib-2.0 gtk+ intltool-native ncurses "
PR = "r2"

inherit gnome

SRC_URI += "file://vte-pkgconfig-fixes.patch;patch=1"

EXTRA_OECONF = "--disable-gtk-doc --disable-python"

do_stage() {
	autotools_stage_all
}

PACKAGES =+ "libvte vte-termcap gnome-pty-helper"
FILES_libvte = "${libdir}/*.so*"
FILES_gnome-pty-helper = "${libexecdir}/gnome-pty-helper"
RDEPENDS_libvte = "vte-termcap"
FILES_vte-termcap = "${datadir}/vte/termcap"
