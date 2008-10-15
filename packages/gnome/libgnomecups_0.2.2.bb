DESCRIPTION="Gnome Cups Manager"
LICENSE="GPLv2"
PR ="r0"

DEPENDS="glib-2.0 gtk+ pango cups intltool libgnomeui"

inherit gnome pkgconfig

do_compile_append () {
	cp libgnomecups-1.0.pc libgnomecups-1.0.pc.old
	sed 's:${STAGING_DIR_HOST}::' < libgnomecups-1.0.pc.old > libgnomecups-1.0.pc
}

do_stage() {
autotools_stage_all
}

