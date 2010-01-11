LICENSE = "LGPL"
SECTION = "x11/gnome"

inherit autotools_stage gnome lib_package

DEPENDS = "gtk+ dbus"

EXTRA_OECONF = "--enable-introspection=no"

do_configure_prepend() {
	sed -i -e 's: doc : :g' ${S}/Makefile.am
}

