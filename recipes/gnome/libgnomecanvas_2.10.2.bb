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

SRC_URI[archive.md5sum] = "976eada7b499ae6e74966f8888c015d1"
SRC_URI[archive.sha256sum] = "82e7700a83aa203afc0c8903642546945b66472c66950cfc443f807b629ecc5a"
