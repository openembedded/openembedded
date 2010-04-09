DESCRIPTION = "Playlist parser for Totem, a GTK2 based media player"
HOMEPAGE = "http://www.gnome.org/projects/totem/"
LICENSE = "GPL"

DEPENDS = "gmime eds-dbus"

inherit gnome

# Build of documentation is not yet possible:
do_configure_prepend() {
	sed -i -e s:docs::g ${S}/Makefile.am
}
