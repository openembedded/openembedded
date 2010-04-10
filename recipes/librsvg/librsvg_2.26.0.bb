DESCRIPTION = "Library for rendering SVG files"
SECTION = "x11/utils"
DEPENDS = "bzip2 gtk+ libcroco cairo libart-lgpl libxml2 popt"
LICENSE = "LGPL"

PR = "r1"

inherit gnome

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

SRC_URI[archive.md5sum] = "65dbd726a514fe8b797d26254b8efc1e"
SRC_URI[archive.sha256sum] = "fdcab5f0d86198d8cbd4ffe5b333076f75e707f6d7e4af5e87a8644ff7533bea"
