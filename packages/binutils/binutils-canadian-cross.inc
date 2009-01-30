SECTION = "devel"
inherit canadian-cross
DEPENDS += "flex-native bison-native"
PROVIDES = "virtual/${TARGET_PREFIX}binutils"
PACKAGES = ""
EXTRA_OECONF = "--with-sysroot=${STAGING_DIR_HOST} \
		--program-prefix=${TARGET_PREFIX} \
		--enable-install-libbfd \
                --disable-werror"

do_stage () {
	# ugly hack introduce to link our staging area up
	mkdir -p ${exec_prefix}/${SDK_SYS}
	ln -s ${STAGING_INCDIR} ${exec_prefix}/${SDK_SYS}/include
	ln -s ${STAGING_LIBDIR} ${exec_prefix}/${SDK_SYS}/lib

	oe_runmake install

	# We don't really need these, so we'll remove them...
	rm -rf ${exec_prefix}/${SDK_SYS}/lib/ldscripts
}

do_install () {
	:
}
