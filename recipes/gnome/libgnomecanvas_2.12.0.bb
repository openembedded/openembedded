LICENSE = "GPL"
SECTION = "x11/gnome/libs"
PR = "r2"
DESCRIPTION = "A powerful object-oriented display"
inherit gnome

DEPENDS = "gnome-vfs libbonobo libglade libart-lgpl"

EXTRA_OECONF = "--disable-gtk-doc"

FILES_${PN} += "${libdir}/libglade/*/libcanvas.so"
FILES_${PN}-dbg += "${libdir}/libglade/*/.debug/libcanvas.so"

do_stage() {
	gnome_stage_includes
	oe_libinstall -C libgnomecanvas -a -so libgnomecanvas-2 ${STAGING_LIBDIR}
}

SRC_URI[archive.md5sum] = "62c0edd3d27803d341662fd9088b2d9b"
SRC_URI[archive.sha256sum] = "77c57dab746a312cd188ce9fcf91bb99b9a7e06d164f438530d65d018afd35da"
