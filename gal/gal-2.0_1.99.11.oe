LICENSE = GPL
SECTION = "x11/libs"
DEPENDS = "intltool libgnomeprint gtk+ libglade libgnomeui libgnomecanvas libxml2 libgnomeprintui"

inherit gnome

SRC_URI = "${GNOME_MIRROR}/gal/1.99/gal-${PV}.tar.bz2 \
	file://configure.patch;patch=1 \
	file://forward-decl.patch;patch=1 \
	file://iconv-detect.h"

S = "${WORKDIR}/gal-${PV}"

do_configure_prepend() {
	cp ${WORKDIR}/iconv-detect.h ${S}/
}

do_stage() {
	gnome_stage_includes
	oe_libinstall -C gal -so -a libgal-2.0 ${STAGING_LIBDIR}
	oe_libinstall -C gal/a11y -so -a libgal-a11y-2.0 ${STAGING_LIBDIR}
}
