require gtkhtml.inc

DEPENDS = "gtk+ virtual/gail libbonoboui libgnomeprintui libgnomeui gal-2.0"
PR = "r1"

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

SRC_URI[md5sum] = "29690b14762a970b9ff725c85627c24b"
SRC_URI[sha256sum] = "ee8dcb9cb850f94e75e374273b0860bcf214fd242651ee22ac74cbfd37449b4f"
