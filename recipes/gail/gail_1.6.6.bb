LICENSE = "LGPL"
SECTION = "x11/libs"
PR = "r1"
DESCRIPTION = "GNOME Accessibility Implementation Library"
DEPENDS = "gtk+ libgnomecanvas"

inherit gnome

EXTRA_OECONF = "--disable-gtk-doc"

FILES_${PN} += "${libdir}/gtk+-2.0/modules/*.so"

do_stage() {
	gnome_stage_includes
	oe_libinstall -C gail -so libgail ${STAGING_LIBDIR}
	oe_libinstall -C libgail-util -so libgailutil ${STAGING_LIBDIR}
}

SRC_URI[archive.md5sum] = "0741e06cd58088d4973dda98d3995a99"
SRC_URI[archive.sha256sum] = "8bbd4713f9bbd752ae3116ec4d6e4f4f04f0f8f774e98dd989626d5e00c121f5"
