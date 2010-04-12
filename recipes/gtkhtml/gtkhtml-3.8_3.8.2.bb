require gtkhtml.inc

DEPENDS = "gtk+ virtual/gail libbonoboui libgnomeprintui libgnomeui"
PR = "r2"

SRC_URI = "${GNOME_MIRROR}/gtkhtml/3.8/gtkhtml-${PV}.tar.bz2"
FILES_${PN} += "${datadir}/gtkhtml-3.8"

do_stage() {
	mv src/libgtkhtml.pc src/libgtkhtml-3.8.pc || true
	gnome_stage_includes
	oe_libinstall -C src -so libgtkhtml-3.8 ${STAGING_LIBDIR}
}

SRC_URI[md5sum] = "4455e24142cc914f00f1e8b81940df68"
SRC_URI[sha256sum] = "d8fc9e7111773448bb07cc2619fbc3b8534a14a9b3075724465c7567cf1a94d0"
