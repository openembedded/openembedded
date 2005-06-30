LICENSE = GPL
SECTION = "x11/libs"
DESCRIPTION = "HTML rendering/editing library"
DEPENDS = "gtk+ gail libbonoboui libgnomeprintui libgnomeui gal-2.0"
PR = "r2"

inherit gnome

SRC_URI = "${GNOME_MIRROR}/gtkhtml/3.0/gtkhtml-${PV}.tar.bz2 \
	file://fix-missing-colormap.patch;patch=1"
FILES_${PN} += "${datadir}/gtkhtml-3.0 ${libdir}/gtkhtml/*.so"
FILES_${PN}-dev += "${libdir}/gtkhtml"
S = "${WORKDIR}/gtkhtml-${PV}"

EXTRA_OECONF = "--disable-gtk-doc"

do_stage() {
	mv src/libgtkhtml.pc src/libgtkhtml-3.0.pc || true
	gnome_stage_includes
	oe_libinstall -C src -so libgtkhtml-3.0 ${STAGING_LIBDIR}
}

do_compile() {
	oe_runmake ORBIT_IDL=${STAGING_BINDIR}/orbit-idl-2
}
