require gdb-cross.inc
LICENSE = "GPLv3"

inherit sdk

# Since we statically link these libraries, we don't dep on the -sdk version
DEPENDS = "ncurses-native zlib-native expat-native flex-native"
EXTRA_OEMAKE = "'SUBDIRS=intl mmalloc libiberty opcodes bfd sim gdb etc utils' LDFLAGS='${BUILD_LDFLAGS}'"

do_configure () {
	cd ${B}
	oe_runmake configure-host
	sed -e 's,-lncurses,${STAGING_LIBDIR_NATIVE}/libncurses.a ${STAGING_LIBDIR_NATIVE}/libtinfo.a ,g' -i ${B}/gdb/Makefile
	sed -e 's,-lz, ${STAGING_LIBDIR_NATIVE}/libz.a ,g' -i ${B}/gdb/Makefile
	sed -e 's,-lexpat, ${STAGING_LIBDIR_NATIVE}/libexpat.a ,g' -i ${B}/gdb/Makefile
	sed -e 's,libexpat.so,libexpat.a ,g' -i ${B}/gdb/Makefile
	for SIM in ${B}/sim/*/Makefile; do
		[ -f $SIM ] && sed -e 's,-lz, ${STAGING_LIBDIR_NATIVE}/libz.a ,g' -i $SIM
	done
	oe_runconf
}
