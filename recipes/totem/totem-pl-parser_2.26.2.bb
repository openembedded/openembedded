DESCRIPTION = "Playlist parser for Totem, a GTK2 based media player"
HOMEPAGE = "http://www.gnome.org/projects/totem/"
LICENSE = "GPL"

DEPENDS = "eds-dbus"

inherit gnome

AUTOTOOLS_STAGE_PKGCONFIG = "1"

do_stage() {
        autotools_stage_all
}

# Build of documentation is not yet possible:
do_configure_prepend() {
	sed -i -e s:docs::g ${S}/Makefile.am
}
