require gnash.inc

do_configure() {
	gnu-configize
	oe_runconf
}
