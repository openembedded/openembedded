LICENSE = "GPL"
SECTION = "x11/gnome/libs"
DEPENDS = "libgnomeprint gtk+ libgnomecanvas gnome-icon-theme gnome-common"

inherit gnome pkgconfig

EXTRA_OECONF = "use_local_libgnomeprint_la=no"

do_stage() {
	autotools_stage_all
}
