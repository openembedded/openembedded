DESCRIPTION = "vte is a virtual terminal emulator"
LICENSE = "LGPL"
PR = "r2"

inherit gnome

EXTRA_OECONF = "--disable-gtk-doc"

do_stage() {
	autotools_stage_all
}

PACKAGES =+ "libvte"
FILES_libvte = "${libdir}/*.so*"
