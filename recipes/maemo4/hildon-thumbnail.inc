LICENSE = "LGPL"
DESCRIPTION = "Nokia hildon thumbnail library"

DEPENDS = "libhildonmime"

inherit autotools pkgconfig lib_package

do_configure_prepend() {
	# remove Werror from OSSO_CFLAGS
	sed -i s:-Werror::g configure.ac

	touch gtk-doc.make
}

