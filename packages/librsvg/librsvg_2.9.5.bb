DESCRIPTION = "Library for rendering SVG files"
SECTION = "x11/utils"
MAINTAINER = "Phil Blundell <pb@handhelds.org>"
DEPENDS = "gtk+ libcroco libart-lgpl libxml2 popt"
LICENSE = "LGPL"
PR = "r3"

inherit autotools pkgconfig gnome

PACKAGES =+ "librsvg-gtk librsvg-gtk-dev rsvg"
FILES_${PN} = "${libdir}/*.so.*"
FILES_rsvg = "${bindir}/rsvg"
FILES_librsvg-gtk = "${libdir}/gtk-2.0/*/*/*.so"
FILES_librsvg-gtk-dev = "${libdir}/gtk-2.0"

do_stage() {
	install -d ${STAGING_INCDIR}/librsvg-2/librsvg/
	install -m 0644 rsvg.h ${STAGING_INCDIR}/librsvg-2/librsvg/
	install -m 0644 librsvg-features.h ${STAGING_INCDIR}/librsvg-2/librsvg/
	oe_libinstall -so -a librsvg-2 ${STAGING_LIBDIR}
}
