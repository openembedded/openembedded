DESCRIPTION = "Playlist parser for Totem, a GTK2 based media player"
HOMEPAGE = "http://www.gnome.org/projects/totem/"
LICENSE = "GPL"

DEPENDS = "gmime eds-dbus"

inherit gnome

# Build of documentation is not yet possible:
do_configure_prepend() {
	sed -i -e s:docs::g ${S}/Makefile.am
}

SRC_URI[archive.md5sum] = "bd4ef8ce1cd3c467cd6adc2835f027bc"
SRC_URI[archive.sha256sum] = "5f71c946cce245d53e8a13281c8dc1884fb6928f0a65d47a6aba7fb18a39acc2"
