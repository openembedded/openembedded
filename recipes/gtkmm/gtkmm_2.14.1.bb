require gtkmm.inc

DEPENDS += "pangomm"

PR = "r0"

# Hack! Remove once gtkmm likes libtool 2x
do_cconfigure() {
	gnu-configize
	oe_runconf
}	
