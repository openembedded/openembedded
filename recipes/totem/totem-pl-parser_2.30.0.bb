DESCRIPTION = "Playlist parser for Totem, a GTK2 based media player"
HOMEPAGE = "http://www.gnome.org/projects/totem/"
LICENSE = "LGPLv2"

PR = "r2"

DEPENDS = "gnome-doc-utils gmime eds-dbus"

inherit gnome

SRC_URI[archive.md5sum] = "81bf8e3043a9ec89bdd391c36ebd50d1"
SRC_URI[archive.sha256sum] = "403b18c1582c14effb4e2dabf339dfdbc45285204a0cf958fc250a387b6fc65c"

# Build of documentation is not yet possible:
do_configure_prepend() {
	sed -i -e 's:GOBJECT_INTROSPECTION_CHECK(\[0.6.7\]):AM_CONDITIONAL([HAVE_INTROSPECTION], [false]):g' ${S}/configure.in
	sed -i -e s:docs::g ${S}/Makefile.am
}

