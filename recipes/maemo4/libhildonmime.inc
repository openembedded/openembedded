LICENSE = "LGPL"
DESCRIPTION = "Nokia hildon mime library"

DEPENDS = "libosso gnome-vfs"

inherit autotools pkgconfig lib_package

do_configure_prepend() {
	# remove Werror from OSSO_CFLAGS
	sed -i s:-Werror::g configure.in
}

