LICENSE = GPL
SECTION = "x11/gnome/libs"
PR = "r1"

inherit gnome

SRC_URI += "file://makefile.patch;patch=1"

DEPENDS = "gnome-vfs libbonobo"

EXTRA_OECONF = "--disable-gtk-doc"

do_stage() {
	oe_libinstall -C libgnome -a -so libgnome-2 ${STAGING_LIBDIR}
	gnome_stage_includes
}
