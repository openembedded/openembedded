LICENSE = "GPL"
SECTION = "x11/gnome"
DEPENDS = "icon-naming-utils-native glib-2.0 intltool-native"
RDEPENDS = "hicolor-icon-theme"
RRECOMMENDS = "librsvg-gtk"

PR = "r2"

FILES_${PN} += "${datadir}/*"

EXTRA_OECONF = "--disable-hicolor-check"

inherit gnome

pkg_postinst_${PN}() {
if [ "x$D" != "x" ]; then
        exit 1
fi

# Update the pixbuf loaders in case they haven't been registered yet
gdk-pixbuf-query-loaders > /etc/gtk-2.0/gdk-pixbuf.loaders

gtk-update-icon-cache -q /usr/share/icons/gnome
}

pkg_postrm_${PN}() {
gtk-update-icon-cache -q /usr/share/icons/gnome
}

