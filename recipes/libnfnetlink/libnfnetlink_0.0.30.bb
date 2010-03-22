include libnfnetlink.inc

PR = "${INC_PR}.0"

do_configure() {
	gnu-configize
	libtoolize --force
	oe_runconf
}
