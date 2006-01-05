LICENSE = "GPL"
SECTION = "x11/libs"
DESCRIPTION = "HTML rendering/editing library"
DEPENDS = "gtk+ gail libbonoboui libgnomeprintui libgnomeui gal-2.0"
MAINTAINER = "Koen Kooi <koen@handhelds.org>"
PR = "r0"

inherit gnome

SRC_URI = "http://ftp.debian.org/debian/pool/main/libg/libgtkhtml2/libgtkhtml2_2.6.3.orig.tar.gz"


FILES_${PN} += "${datadir}/gtkhtml-3.0 ${libdir}/gtkhtml/*.so"
FILES_${PN}-dev += "${libdir}/gtkhtml"
S = "${WORKDIR}/libgtkhtml2-${PV}"

EXTRA_OECONF = "--disable-gtk-doc"

do_stage() {
	mv src/libgtkhtml.pc src/libgtkhtml-2.0.pc || true
    autotools_stage_all
}

do_compile() {
	oe_runmake ORBIT_IDL=${STAGING_BINDIR}/orbit-idl-2
}
