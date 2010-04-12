LICENSE = "GPL"
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

SRC_URI[md5sum] = "906c0640d3160a55aac98974aecfb316"
SRC_URI[sha256sum] = "bb76484f73f5d6bc58d4e9990422043663af01204728aee73a1ce4565f8ef2ed"
