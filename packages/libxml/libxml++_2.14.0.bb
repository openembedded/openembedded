LICENSE = "GPL"

DEPENDS = "gtk+"

inherit gnome pkgconfig

do_stage() {
autotools_stage_all
}
