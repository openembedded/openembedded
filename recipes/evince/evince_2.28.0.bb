DESCRIPTION = "Evince is a document viewer for document formats like pdf, ps, djvu."
LICENSE = "GPL"
SECTION = "x11/office"
DEPENDS = "nautilus gnome-icon-theme tiff libxt espgs gnome-doc-utils poppler libxml2 gtk+ gconf libglade gnome-keyring "
RDEPENDS = "espgs gnome-icon-theme"

PR = "r1"

inherit gnome pkgconfig gtk-icon-cache

EXTRA_OECONF = "  \
                 --enable-thumbnailer \
                 --enable-nautilus \ 
                 --disable-scrollkeeper \
                 --enable-djvu \
                 --enable-pixbuf \
		 "

do_install_append() {
	sed -i "s/NoDisplay=true//" ${D}${datadir}/applications/evince.desktop
	sed -i "s/;Viewer;/;Viewer;Office;/" ${D}${datadir}/applications/evince.desktop
	install -d install -d ${D}${datadir}/pixmaps
	install -m 0755 ${S}/data/icons/48x48/apps/evince.png ${D}${datadir}/pixmaps/
}

do_stage () {
	 autotools_stage_all
}

FILES_${PN}-dbg += "${libdir}/evince/1/backends/.debug"

PACKAGES =+ "evince-nautilus-extension"

FILES_evince-nautilus-extension = "${libdir}/nautilus/*/*so"


