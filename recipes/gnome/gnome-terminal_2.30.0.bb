DESCRIPTION = "GNOME terminal"
SECTION = "x11/gnome"
LICENSE = "GPL"
DEPENDS = "gnome-common glib-2.0 gtk+ gconf vte"
inherit gnome pkgconfig

SRC_URI[archive.md5sum] = "fb2215dcb78206b86b27a33241235f61"
SRC_URI[archive.sha256sum] = "989e251a8407952b8c42fa74c8049a485504dfe3c82663946c7b538199b0c5d5"

EXTRA_OECONF = "--disable-scrollkeeper"

do_configure_prepend () {
	cp ${STAGING_DATADIR}/gnome-common/data/omf.make ${S}
}


