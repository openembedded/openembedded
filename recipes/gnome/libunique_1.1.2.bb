LICENSE = "LGPL"
SECTION = "x11/gnome"

inherit gnome lib_package

DEPENDS = "gtk+ dbus"

EXTRA_OECONF = "--enable-introspection=no"

do_configure_prepend() {
	sed -i -e 's: doc : :g' ${S}/Makefile.am
}


SRC_URI[archive.md5sum] = "f33749109768d43ef69ca7e8ffa7cfb7"
SRC_URI[archive.sha256sum] = "73fb130295fc42b237aa3d808905f65ead9f979acbe49434eca830c6085f0c6e"
