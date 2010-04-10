LICENSE = "GPL"
SECTION = "x11/gnome/libs"
DESCRIPTION = "A powerful object-oriented display"

inherit gnome

DEPENDS = "libglade libart-lgpl"

EXTRA_OECONF = "--disable-gtk-doc"

FILES_${PN} += "${libdir}/libglade/*/libcanvas.so"
FILES_${PN}-dbg += "${libdir}/libglade/*/.debug/"
FILES_${PN}-dev += "${libdir}/libglade/*/libcanvas.*a"

do_stage() {
	autotools_stage_all
}

SRC_URI[archive.md5sum] = "516c46fb4a1401b05cfef58c350fbd3d"
SRC_URI[archive.sha256sum] = "5ceadd704327c2967868b3c0c81b5e600e1c6fd4f8efcbaaf89f9b18aa8bb5cf"
