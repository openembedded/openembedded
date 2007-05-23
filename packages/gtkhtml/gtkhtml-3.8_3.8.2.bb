require gtkhtml.inc

DEPENDS = "gtk+ gail libbonoboui libgnomeprintui libgnomeui"

SRC_URI = "${GNOME_MIRROR}/gtkhtml/3.8/gtkhtml-${PV}.tar.bz2"
FILES_${PN} += "${datadir}/gtkhtml-3.8"

do_stage() {
	mv src/libgtkhtml.pc src/libgtkhtml-3.8.pc || true
	gnome_stage_includes
	oe_libinstall -C src -so libgtkhtml-3.8 ${STAGING_LIBDIR}
}
