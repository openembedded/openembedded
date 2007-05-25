require gtkhtml.inc

DEPENDS = "gtk+ gail libbonoboui libgnomeprintui libgnomeui gal-2.0"
PR = "r0"

SRC_URI = "http://ftp.debian.org/debian/pool/main/libg/libgtkhtml2/libgtkhtml2_2.6.3.orig.tar.gz"

FILES_${PN} += "${datadir}/gtkhtml-3.0 ${libdir}/gtkhtml/*.so"
FILES_${PN}-dev += "${libdir}/gtkhtml"

do_stage() {
    mv src/libgtkhtml.pc src/libgtkhtml-2.0.pc || true
    autotools_stage_all
}

do_compile() {
	oe_runmake ORBIT_IDL=${STAGING_BINDIR_NATIVE}/orbit-idl-2
}
