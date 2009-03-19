require gtkhtml.inc

DEPENDS = "gtk+ gail libgnomeprint orbit2-native"
PR = "r1"

SRC_URI = "http://stag.mind.be/gtkhtml-lite-3.0.10.tar.bz2"
FILES_${PN} += "${datadir}/gtkhtml-3.0 ${libdir}/gtkhtml/*.so"
FILES_${PN}-dev += "${libdir}/gtkhtml"

do_stage() {
	mv src/libgtkhtml.pc src/libgtkhtml-3.0.pc || true
	gnome_stage_includes
	oe_libinstall -C src -so libgtkhtml-3.0 ${STAGING_LIBDIR}
}

do_compile() {
	oe_runmake ORBIT_IDL=${STAGING_BINDIR_NATIVE}/orbit-idl-2
}
