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


SRC_URI[archive.md5sum] = "959d5524fe9c37efb55ccfa02e3a063b"
SRC_URI[archive.sha256sum] = "f70599274dbb575fbbc83bb58179b757800e5d87e59e35f5d95e618c7ec31444"
