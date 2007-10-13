require gutenprint.inc

DEPENDS = "glib-2.0 cups tiff jpeg libpng gutenprint-native espgs"

SRC_URI = "http://easynews.dl.sourceforge.net/sourceforge/gimp-print/gutenprint-5.1.3.tar.bz2"
S = "${WORKDIR}/gutenprint-${PV}"


EXTRA_OECONF = "\
		--disable-nls \
		 --disable-gtktest \
#		--enable-cups-ppds \
# this option is disabled here, since the ppds are generated during native build
		 --disable-libgutenprintui \
		 --disable-libgutenprintui2 \
		--disable-translated-cups-ppds \
#		--with-ghostscript \
# i MAY have to disable this one as well, since these are probably built in native as well
		--enable-cups-level3-ppds \
		 --disable-gimptest \
		--enable-test \
		--enable-epson \
		--with-user-guide \
		--with-samples \
		--with-escputil \
		 "		   		   

do_configure() {
        gnu-configize
	libtoolize --force
        oe_runconf
}


