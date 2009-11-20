DESCRIPTION = "GNOME editor"
SECTION = "x11/gnome"
LICENSE = "GPL"

DEPENDS = "iso-codes gnome-common glib-2.0 gtk+ gconf gtksourceview2"
RDEPENDS += " gtksourceview2"

PR = "r1"

inherit gnome pkgconfig

EXTRA_OECONF = "--disable-scrollkeeper"

do_configure_prepend () {
	cp ${STAGING_DATADIR}/gnome-common/data/omf.make ${S}
}

do_stage () {
	autotools_stage_all
}

FILES_${PN} += "${libdir}/gedit-2/plugin* ${datadir}/gedit-2"
FILES_${PN}-dbg += "${libdir}/gedit-2/plugin-loaders/.debug ${libdir}/gedit-2/plugins/.debug"
