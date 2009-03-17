SECTION = "libs"
require gutenprint_${PV}.bb
DEPENDS = ""
inherit native

EXTRA_OECONF = "\
		--disable-nls \
		--disable-gtktest \
		--enable-cups-ppds \
		--disable-libgutenprintui \
		--disable-libgutenprintui2 \
		--disable-translated-cups-ppds \
		--with-ghostscript \
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




do_stage() {
	autotools_stage_includes
	install -m 0755 -d ${STAGING_DATADIR}/cups/model
	install -m 0644 src/cups/ppd/C/*ppd* ${STAGING_DATADIR}/cups/model/   
#	oe_libinstall -so -a -C objs libfreetype ${STAGING_LIBDIR}
}


