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

SRC_URI[md5sum] = "ec541b078ea9fbb1dd93f77075f77bd8"
SRC_URI[sha256sum] = "867036b10dd4b21f79bc0d8b303d348ff55cb4ded896c8cb384b2bb4bbf378d7"
