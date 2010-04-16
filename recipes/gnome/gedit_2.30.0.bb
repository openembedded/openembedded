DESCRIPTION = "GNOME editor"
SECTION = "x11/gnome"
LICENSE = "GPL"

DEPENDS = "iso-codes gnome-common glib-2.0 gtk+ gconf gtksourceview2"
RDEPENDS += " gtksourceview2"

inherit gnome
SRC_URI[archive.md5sum] = "aebd49797406fdde7b25624b71990860"
SRC_URI[archive.sha256sum] = "37598473372aab217e46f19726cff616ff0ea4121bbdbb170b4e264a4ca76690"

EXTRA_OECONF = "--disable-scrollkeeper"

do_configure_prepend () {
	cp ${STAGING_DATADIR}/gnome-common/data/omf.make ${S}
}

FILES_${PN} += "${libdir}/gedit-2/plugin* ${datadir}/gedit-2"
FILES_${PN}-dbg += "${libdir}/gedit-2/plugin-loaders/.debug ${libdir}/gedit-2/plugins/.debug"

