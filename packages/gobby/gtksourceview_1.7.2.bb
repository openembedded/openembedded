LICENSE = "GPL"

DEPENDS = "gtk+ libgnomeprint"

inherit gnome pkgconfig

do_stage() {
autotools_stage_all
}
