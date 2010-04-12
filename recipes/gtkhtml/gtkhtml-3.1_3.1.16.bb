require gtkhtml.inc

DEPENDS = "gtk+ virtual/gail libbonoboui libgnomeprintui libgnomeui"
PR = "r2"

SRC_URI = "${GNOME_MIRROR}/gtkhtml/3.1/gtkhtml-${PV}.tar.bz2"
FILES_${PN} += "${datadir}/gtkhtml-3.1"

do_stage() {
	mv src/libgtkhtml.pc src/libgtkhtml-3.1.pc || true
	gnome_stage_includes
	oe_libinstall -C src -so libgtkhtml-3.1 ${STAGING_LIBDIR}
}

SRC_URI[md5sum] = "a16fc3d5e2c7b3d94791bf797588adc3"
SRC_URI[sha256sum] = "a5b138e5cfa1f5c2c4dbb0a071d5492d49142c363ec9b92da8d7e3a6e6bb35b5"
