SECTION = "devel"
inherit cross
DEPENDS += "flex-native bison-native"
PROVIDES = "virtual/${TARGET_PREFIX}binutils"
PACKAGES = ""
EXTRA_OECONF = "--with-sysroot=${STAGING_DIR_TARGET} \
		--program-prefix=${TARGET_PREFIX} \
		--enable-install-libbfd \
                --disable-werror"

# --enable-install-libiberty"

do_stage () {
	oe_runmake install

	install -d ${CROSS_DIR}/include
	install -m 0644 ${S}/include/libiberty.h ${CROSS_DIR}/include

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
}

do_install () {
  :
# this already happens, don't know why
#	install -d ${CROSS_DIR}/lib
#	install -m 0644 ${S}/lib/libiberty.a ${CROSS_DIR}/lib
}
