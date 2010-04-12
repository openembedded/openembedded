DESCRIPTION = "GNOME terminal"
SECTION = "x11/gnome"
LICENSE = "GPL"
DEPENDS = "gnome-common glib-2.0 gtk+ gconf vte"
inherit gnome pkgconfig

PR = "r1"

EXTRA_OECONF = "--disable-scrollkeeper"

do_configure_prepend () {
	cp ${STAGING_DATADIR}/gnome-common/data/omf.make ${S}
}

do_stage () {
	autotools_stage_all
}



SRC_URI[archive.md5sum] = "9cdc3581a03a44dd693663991d1c1e9f"
SRC_URI[archive.sha256sum] = "c3f1ce6248e47cac5f3c5c0a79a079d5c7756ba1c4867eb43e20e929087b4a5a"
