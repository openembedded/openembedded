DESCRIPTION="Gnome Cups Manager"
LICENSE="GPLv2"
PR="r0"

DEPENDS="glib-2.0 gtk+ pango cups"

inherit gnome pkgconfig

do_stage() {
autotools_stage_all
}

