


DEPENDS = "glib-2.0 gtk+ cups"

inherit autotools pkgconfig

SRC_URI = "${SOURCEFORGE_MIRROR}/gimp-print/${P}.tar.bz2"

EXTRA_OECONF = "\
		 --disable-gtktest \
		 --disable-libgutenprintui \
		 --enable-libgutenprintui2 \
		 --enable-translated-cups-ppds \
		 --disable-gimptest \
		 "

do_configure() {
	oe_runconf
}


