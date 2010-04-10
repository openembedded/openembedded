DESCRIPTION = "An archive manager for the GNOME environment"
LICENSE="GPL"
SECTION = "x11/gnome"
DEPENDS="gtk+ libgnomeui gnome-common gnome-vfs libglade libbonoboui"
RDEPENDS = "unzip"

PR = "r2"

inherit gnome

do_configure_prepend () {
	cp ${STAGING_DATADIR}/gnome-common/data/omf.make ${S}
}

FILES_${PN} += " \
                ${libdir}/nautilus/extensions-2.0 \
               "

FILES_${PN}-dbg += " \
                ${libdir}/nautilus/extensions-2.0/.debug \
                ${libexecdir}/file-roller/.debug \
               "


SRC_URI[archive.md5sum] = "dcb0c887d5d287a28ebb5c0ea69bedfa"
SRC_URI[archive.sha256sum] = "499fe835b297720f4e4054b4ab34a3fb619c3460c5da82b1519d9b86aa2f3ac2"
