DESCRIPTION = "Gutenprint printer drivers"
HOMEPAGE = "http://gimp-print.sourceforge.net/"
LICENSE = "GPL"

DEPENDS = "glib-2.0 cups tiff jpeg libpng gutenprint-native espgs"


inherit autotools pkgconfig
PARALLEL_MAKE=""

#EXTRA_OECONF = "\
#		--disable-nls \
#		 --disable-gtktest \
#		--enable-cups-ppds \
#		 --disable-libgutenprintui \
#		 --disable-libgutenprintui2 \
#		--disable-translated-cups-ppds \
#		--with-ghostscript \
#		--enable-cups-level3-ppds \
#		 --disable-gimptest \
#		--enable-test \
#		--enable-epson \
#		--with-user-guide \
#		--with-samples \
#		--with-escputil \
#		 "


