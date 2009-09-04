require gtkhtml.inc

DEPENDS = "gtk+ virtual/gail libbonoboui libgnomeprintui libgnomeui"
PR = "r2"

SRC_URI = "${GNOME_MIRROR}/gtkhtml/3.18/gtkhtml-${PV}.tar.bz2"
FILES_${PN} += "${datadir}/gtkhtml-3.8"

do_stage() {
	mv gtkhtml/libgtkhtml.pc gtkhtml/libgtkhtml-3.8.pc || true
	gnome_stage_includes
	oe_libinstall -C gtkhtml -so libgtkhtml-3.14 ${STAGING_LIBDIR}
}
