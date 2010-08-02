LICENSE = "LGPL"
DESCRIPTION = "Nokia osso connection library"

DEPENDS = "libosso"

inherit autotools pkgconfig 

do_configure_prepend() {
	# remove Werror from OSSO_CFLAGS
	sed -i s:-Werror::g configure.ac
}

