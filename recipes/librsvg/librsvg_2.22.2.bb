DESCRIPTION = "Library for rendering SVG files"
SECTION = "x11/utils"
DEPENDS = "gtk+ libcroco cairo libart-lgpl libxml2 popt"
LICENSE = "LGPL"

inherit autotools pkgconfig gnome

EXTRA_OECONF = "--disable-mozilla-plugin"


PACKAGES =+ "librsvg-gtk librsvg-gtk-dbg librsvg-gtk-dev rsvg"
FILES_${PN} = "${libdir}/*.so.*"
FILES_rsvg = "${bindir}/rsvg \
	      ${bindir}/rsvg-view \
	      ${bindir}/rsvg-convert \
	      ${datadir}/pixmaps/svg-viewer.svg"
FILES_librsvg-gtk = "${libdir}/gtk-2.0/*/*/*.so"
FILES_librsvg-gtk-dev += "${libdir}/gtk-2.0/*.la \
			  ${libdir}/gtk-2.0/*/*.la \
			  ${libdir}/gtk-2.0/*/*/*.la \
			  "
FILES_librsvg-gtk-dbg += "${libdir}/gtk-2.0/.debug \
                          ${libdir}/gtk-2.0/*/*/.debug"

pkg_postinst_librsvg-gtk() {
if [ "x$D" != "x" ]; then
        exit 1
fi
        gdk-pixbuf-query-loaders > /etc/gtk-2.0/gdk-pixbuf.loaders
}

do_stage() {
	autotools_stage_all
}

SRC_URI[archive.md5sum] = "aae602677ce201b1a0ed6a0c18c207f2"
SRC_URI[archive.sha256sum] = "2bfc1853ecdc545bf3767ed92c93b8796f2075f522c8eab1693c96f11d55a59e"
