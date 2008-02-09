LICENSE = "GPL"

DEPENDS = "gtk+ glibmm"

inherit gnome pkgconfig

do_stage() {
autotools_stage_all
}
