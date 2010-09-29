require gdb-cross.inc
LICENSE = "GPLv3"

inherit sdk

DEPENDS = "ncurses-sdk zlib-sdk flex-native"
EXTRA_OEMAKE = "'SUBDIRS=intl mmalloc libiberty opcodes bfd sim gdb etc utils' LDFLAGS='${BUILD_LDFLAGS}'"

do_configure_append () {
	cd ${B}
	oe_runmake configure-host
	sed -e 's,-lncurses,${STAGING_LIBDIR_NATIVE}/libncurses.a ${STAGING_LIBDIR_NATIVE}/libtinfo.a ,g' -i ${B}/gdb/Makefile
	sed -e 's,-lz, ${STAGING_LIBDIR_NATIVE}/libz.a ,g' -i ${B}/gdb/Makefile
	sed -e 's,-lexpat, ${STAGING_LIBDIR_NATIVE}/libexpat.a ,g' -i ${B}/gdb/Makefile
	sed -e 's,libexpat.so,libexpat.a ,g' -i ${B}/gdb/Makefile
	sed -e 's,-lz, ${STAGING_LIBDIR_NATIVE}/libz.a ,g' -i ${B}/sim/*/Makefile
}
