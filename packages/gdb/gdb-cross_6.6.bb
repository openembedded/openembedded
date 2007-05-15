require gdb-cross.inc

PR = "r1"

SRC_URI += "file://sim-install-makefile.patch;patch=1"

do_configure () {
# override this function to avoid the autoconf/automake/aclocal/autoheader
# calls for now
	gnu-configize
	oe_runconf
}

do_stage() {
	:	
}
