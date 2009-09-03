DESCRIPTION = "flash plugin"
LICENSE = "GPL"

DEPENDS = "gtk+ gconf swfdec"

inherit gnome pkgconfig

do_configure_prepend() {
	sed -i -e 's/swfdec-$SWFDEC_MAJORMINOR/swfdec/g' configure.ac
	sed -i -e 's/swfdec-gtk-$SWFDEC_MAJORMINOR/swfdec-gtk/g' configure.ac
}

