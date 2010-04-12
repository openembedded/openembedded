require gtkhtml.inc

DEPENDS = "gtk+ virtual/gail libgnomeprint orbit2-native"
PR = "r2"

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

SRC_URI[md5sum] = "1a3e312cec38645c2f811282566d12b0"
SRC_URI[sha256sum] = "a16751d55a1a635eb2d04613353884c5bdb2ad2fc3afa4b951aa2868552602a9"
