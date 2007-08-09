require gdb-cross.inc

PR = "r1"

SRC_URI += "file://sim-install-makefile.patch;patch=1 \
	file://sim-install-makefile-common.patch;patch=1"

do_configure () {
# override this function to avoid the autoconf/automake/aclocal/autoheader
# calls for now
	gnu-configize
	oe_runconf
}

do_stage() {
	oe_runmake 'DESTDIR=${CROSS_DIR}' install
	cp -pPR ${CROSS_DIR}${prefix}/* ${CROSS_DIR}
	rm -rf ${CROSS_DIR}${prefix}
}
