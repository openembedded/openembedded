LICENSE = "GPL"
SECTION = "x11/libs"
DESCRIPTION = "HTML rendering/editing library"
DEPENDS = "gtk+ gail libbonoboui libgnomeprintui libgnomeui"

inherit gnome

SRC_URI = "${GNOME_MIRROR}/gtkhtml/3.8/gtkhtml-${PV}.tar.bz2"
FILES_${PN} += "${datadir}/gtkhtml-3.8"
S = "${WORKDIR}/gtkhtml-${PV}"

EXTRA_OECONF = "--disable-gtk-doc"

do_stage() {
	mv src/libgtkhtml.pc src/libgtkhtml-3.8.pc || true
	gnome_stage_includes
	oe_libinstall -C src -so libgtkhtml-3.8 ${STAGING_LIBDIR}
}
