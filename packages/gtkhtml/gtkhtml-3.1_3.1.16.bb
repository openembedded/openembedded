require gtkhtml.inc

DEPENDS = "gtk+ gail libbonoboui libgnomeprintui libgnomeui"

SRC_URI = "${GNOME_MIRROR}/gtkhtml/3.1/gtkhtml-${PV}.tar.bz2"
FILES_${PN} += "${datadir}/gtkhtml-3.1"

do_stage() {
	mv src/libgtkhtml.pc src/libgtkhtml-3.1.pc || true
	gnome_stage_includes
	oe_libinstall -C src -so libgtkhtml-3.1 ${STAGING_LIBDIR}
}
