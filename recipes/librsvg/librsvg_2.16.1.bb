DESCRIPTION = "Library for rendering SVG files"
SECTION = "x11/utils"
DEPENDS = "gtk+ libcroco cairo libart-lgpl libxml2 popt"
LICENSE = "LGPL"

PR = "r2"

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

SRC_URI[archive.md5sum] = "37e046571097ff7ce77ae6e07f096324"
SRC_URI[archive.sha256sum] = "2989d6a969b6f80d354f8120a5dd625d2c0b4e9e04bf178e9e7b34ae28e2ac69"
