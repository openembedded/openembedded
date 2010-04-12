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

SRC_URI[archive.md5sum] = "d5e8f9f2806c9662693f292b155dd238"
SRC_URI[archive.sha256sum] = "f12699367ec4f48ffce87f8b116b55561a03e055c4bf74cc96e5adb3b4e2fce6"
