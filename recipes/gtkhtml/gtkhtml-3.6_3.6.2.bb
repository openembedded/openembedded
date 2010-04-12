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

SRC_URI[md5sum] = "37465fde0f1e1d7ba2284c5a4fd06fe7"
SRC_URI[sha256sum] = "0c34357bd2b4ed3584e18a30f13a9f5d4c70738872ef90db97c1298013b2f7b9"
