LICENSE = "LGPL"
SECTION = "x11/libs"
PR = "r0"
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

SRC_URI[archive.md5sum] = "7587a0a9ee643bb59ef6b2dea06c5a28"
SRC_URI[archive.sha256sum] = "1313a35d6cc4d3ae466dbb6b4f1588b341f339c071557fd66830c0daf72f09b4"
