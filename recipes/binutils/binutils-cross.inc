SECTION = "devel"
inherit cross
DEPENDS += "flex-native bison-native"
PROVIDES = "virtual/${TARGET_PREFIX}binutils"
PACKAGES = ""
EXTRA_OECONF = "--with-sysroot=${STAGING_DIR_TARGET} \
		--program-prefix=${TARGET_PREFIX} \
		--enable-install-libbfd \
                --disable-werror"

do_stage () {
	oe_runmake install

	# We don't really need these, so we'll remove them...
	rm -rf ${CROSS_DIR}/lib/ldscripts
	rm -rf ${CROSS_DIR}/share/info
	rm -rf ${CROSS_DIR}/share/locale
	rm -rf ${CROSS_DIR}/share/man
	rmdir ${CROSS_DIR}/share || :
	rmdir ${CROSS_DIR}/${libdir}/gcc-lib || :
	rmdir ${CROSS_DIR}/${libdir}64/gcc-lib || :
	rmdir ${CROSS_DIR}/${libdir} || :
	rmdir ${CROSS_DIR}/${libdir}64 || :
	rmdir ${CROSS_DIR}/${prefix} || :

	LIBBFD_DIR_BASE=${CROSS_DIR}/${BUILD_SYS}/${TARGET_SYS}
	# We want to move libbfd and libopcodes to  ${CROSS_DIR}/lib
	mkdir -p ${CROSS_DIR}/lib
	mv -f ${LIBBFD_DIR_BASE}/lib/* ${CROSS_DIR}/lib || \
		mv -f ${LIBBFD_DIR_BASE}/lib64/* ${CROSS_DIR}/lib
	rmdir ${LIBBFD_DIR_BASE}/lib || :
	rmdir ${LIBBFD_DIR_BASE}/lib64 || :
	
	# Adjust libbfd.la and libopcodes.la
	for i in libbfd.la libopcodes.la; do
	sed -i -e "s@${LIBBFD_DIR_BASE}/lib64@${CROSS_DIR}/lib@" ${CROSS_DIR}/lib/$i
	sed -i -e "s@${LIBBFD_DIR_BASE}/lib@${CROSS_DIR}/lib@" ${CROSS_DIR}/lib/$i
	done

	# libbfd headers should be moved as well
	mkdir -p ${CROSS_DIR}/include
	mv -f ${LIBBFD_DIR_BASE}/include/* ${CROSS_DIR}/include
	rmdir ${LIBBFD_DIR_BASE}/include 

	# Remove empty directories
	rmdir ${CROSS_DIR}/${BUILD_SYS}/${TARGET_SYS} || :
	rmdir ${CROSS_DIR}/${BUILD_SYS} || :
}

do_install () {
	:
}
