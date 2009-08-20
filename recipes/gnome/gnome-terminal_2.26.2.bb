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


