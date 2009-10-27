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

