LICENSE = "LGPL"
DESCRIPTION = "Nokia hildon help library"

DEPENDS = "gtk+ intltool-native libxml2 gtkhtml-3.8 libosso libhildon"

inherit autotools pkgconfig lib_package

do_configure_prepend() {
	# remove Werror from OSSO_CFLAGS
	sed -i s:-Werror::g configure.ac
}

