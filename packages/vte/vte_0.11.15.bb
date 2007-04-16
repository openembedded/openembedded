LICENSE = "LGPL"

inherit gnome

EXTRA_OECONF = "--disable-gtk-doc"

do_stage() {
autotools_stage_all
}
