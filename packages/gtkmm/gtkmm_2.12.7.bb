require gtkmm.inc

PR = "r0"

# Hack! Remove once gtkmm likes libtool 2x
do_configure() {
	gnu-configize
	oe_runconf
}	
