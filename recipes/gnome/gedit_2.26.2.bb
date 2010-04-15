DESCRIPTION = "GNOME editor"
SECTION = "x11/gnome"
LICENSE = "GPL"

DEPENDS = "iso-codes gnome-common glib-2.0 gtk+ gconf gtksourceview2"
RDEPENDS += " gtksourceview2"

inherit gnome pkgconfig

EXTRA_OECONF = "--disable-scrollkeeper"

do_configure_prepend () {
	cp ${STAGING_DATADIR}/gnome-common/data/omf.make ${S}
}

FILES_${PN} += "${libdir} ${datadir}/gedit-2"
FILES_${PN}-dbg += "${libdir}/gedit-2/plugin-loaders/.debug ${libdir}/gedit-2/plugins/.debug"

SRC_URI[archive.md5sum] = "ef8c98051c03d0caf0c75456e48c25b0"
SRC_URI[archive.sha256sum] = "7ce4919b4742ad6aad9dbfb2b962434d70dbcf9c63bb513870f3276deb28bee0"
