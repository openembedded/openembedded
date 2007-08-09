require gdb-cross.inc

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
