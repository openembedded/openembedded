require gdb-cross.inc
LICENSE = "GPLv3"

inherit sdk
EXTRA_OEMAKE = "'SUBDIRS=intl mmalloc libiberty opcodes bfd sim gdb etc utils' LDFLAGS='${BUILD_LDFLAGS}'"

# Since we statically link against the required host libraries we don't 
# add a depenency on the -sdk versions of them.
do_configure_append () {
	cd ${B}
	oe_runconf
	oe_runmake configure-host
	sed -e 's,-lncurses,${STAGING_LIBDIR_NATIVE}/libncurses.a ${STAGING_LIBDIR_NATIVE}/libtinfo.a ,g' -i ${B}/gdb/Makefile
	sed -e 's,-lz, ${STAGING_LIBDIR_NATIVE}/libz.a ,g' -i ${B}/gdb/Makefile
	sed -e 's,-lexpat, ${STAGING_LIBDIR_NATIVE}/libexpat.a ,g' -i ${B}/gdb/Makefile
	sed -e 's,libexpat.so,libexpat.a ,g' -i ${B}/gdb/Makefile
	for SIM in ${B}/sim/*/Makefile
	do
		if [ -f $SIM ]
		then
			sed -e 's,-lz, ${STAGING_LIBDIR_NATIVE}/libz.a ,g' -i $SIM
		fi
	done
}
