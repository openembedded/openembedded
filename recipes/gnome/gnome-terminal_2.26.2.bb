DESCRIPTION = "GNOME terminal"
SECTION = "x11/gnome"
LICENSE = "GPL"
DEPENDS = "gnome-common glib-2.0 gtk+ gconf vte"
inherit gnome pkgconfig

EXTRA_OECONF = "--disable-scrollkeeper"

do_configure_prepend () {
	cp ${STAGING_DATADIR}/gnome-common/data/omf.make ${S}
}

do_stage () {
	autotools_stage_all
}



SRC_URI[archive.md5sum] = "f4f64b9b67c7a3147799ee10f7cf00e1"
SRC_URI[archive.sha256sum] = "f937939eca0082dc7f3f9ddab72d612433ad948aac7e158ed75f5d7053e8d0e0"
