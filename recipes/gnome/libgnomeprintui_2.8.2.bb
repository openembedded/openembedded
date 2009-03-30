LICENSE = "GPL"
SECTION = "x11/gnome/libs"
PR = "r1"
DEPENDS = "libgnomeprint gtk+ libgnomecanvas gnome-icon-theme gnome-common"

inherit gnome pkgconfig

SRC_URI += "file://configure.patch;patch=1"

do_stage() {
	install -d ${STAGING_LIBDIR}
	oe_libinstall -so -a -C libgnomeprintui libgnomeprintui-2-2 ${STAGING_LIBDIR}
	gnome_stage_includes
}
