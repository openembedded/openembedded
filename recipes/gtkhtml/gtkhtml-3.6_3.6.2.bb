require gtkhtml.inc

DEPENDS = "gtk+ virtual/gail libbonoboui libgnomeprintui libgnomeui"
PR = "r2"

SRC_URI = "${GNOME_MIRROR}/gtkhtml/3.6/gtkhtml-${PV}.tar.bz2 \
	file://cross-includedir.patch;patch=1"
PR = "r1"
FILES_${PN} += "${datadir}/gtkhtml-3.6"

do_stage() {
	mv src/libgtkhtml.pc src/libgtkhtml-3.6.pc || true
	gnome_stage_includes
	oe_libinstall -C src -so libgtkhtml-3.6 ${STAGING_LIBDIR}
}
