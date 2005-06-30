LICENSE = GPL
SECTION = "x11/gnome/libs"
PR = "r1"

DEPENDS = "libxml2 glib-2.0 pango libart-lgpl fontconfig popt gnome-common"

inherit flow-lossage pkgconfig gnome

do_stage() {
	install -d ${STAGING_LIBDIR}
	oe_libinstall -so -a -C libgnomeprint libgnomeprint-2-2 ${STAGING_LIBDIR}
	gnome_stage_includes
}
