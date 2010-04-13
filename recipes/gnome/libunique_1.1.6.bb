LICENSE = "LGPL"
SECTION = "x11/gnome"

inherit autotools_stage gnome lib_package

SRC_URI[archive.md5sum] = "7955769ef31f1bc4f83446dbb3625e6d"
SRC_URI[archive.sha256sum] = "e5c8041cef8e33c55732f06a292381cb345db946cf792a4ae18aa5c66cdd4fbb"

DEPENDS = "gtk+ dbus"

EXTRA_OECONF = "--enable-introspection=no"

do_configure_prepend() {
	sed -i -e 's: doc : :g' ${S}/Makefile.am
}

