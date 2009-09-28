require glibmm.inc

do_configure() {
	libtoolize --force
	gnu-configize
	oe_runconf
}


