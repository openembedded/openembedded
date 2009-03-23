LICENSE = "GPL"
SECTION = "x11/gnome"

inherit gnome

DEPENDS = "gtk+"

EXTRA_OECONF = "--disable-gtk-doc"


do_stage() {
        autotools_stage_all
}
