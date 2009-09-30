DESCRIPTION = "An archive manager for the GNOME environment"
LICENSE="GPL"
SECTION = "x11/gnome"

DEPENDS="gtk+ libgnomeui gnome-common gnome-vfs libglade libbonoboui"

inherit gnome

do_configure_prepend () {
	cp ${STAGING_DATADIR}/gnome-common/data/omf.make ${S}
}

FILES_${PN}-dbg += " \
                ${libexecdir}/file-roller/.debug \
               "

