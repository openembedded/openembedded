DESCRIPTION = "Evince is a document viewer for document formats like pdf, ps, djvu."
LICENSE = "GPL"
SECTION = "x11/office"
DEPENDS = "nautilus gnome-icon-theme tiff libxt espgs gnome-doc-utils poppler libxml2 gtk+ gconf libglade gnome-keyring "
RDEPENDS = "espgs gnome-icon-theme"

inherit gnome pkgconfig gtk-icon-cache

SRC_URI[archive.md5sum] = "a55f1997891a64157286b6f6b00f8458"
SRC_URI[archive.sha256sum] = "36dfee4e973421f15cb51c9b1c84784523592dc81feb6465fb59f87b8f7f8bf7"

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

FILES_${PN}-dbg += " \
                    ${libdir}/evince/1/backends/.debug \
                    ${libdir}/evince/2/backends/.debug \
                   "

PACKAGES =+ "evince-nautilus-extension"

FILES_evince-nautilus-extension = "${libdir}/nautilus/*/*so"


