PR = "r3"

require gcc-${PV}.inc
require gcc-cross.inc
require gcc-package-cross.inc

EXTRA_OECONF_PATHS = "--with-local-prefix=${CROSS_DIR}/${TARGET_SYS} \
		--with-gxx-include-dir=${CROSS_DIR}/${TARGET_SYS}/include/c++"

export CPPFLAGS = ""
export CXXFLAGS = ""
export CFLAGS = ""
export LDFLAGS = ""

do_configure () {
	export CC="${BUILD_CC}"
	export AR="${TARGET_SYS}-ar"
	export RANLIB="${TARGET_SYS}-ranlib"
	export LD="${TARGET_SYS}-ld"
	export NM="${TARGET_SYS}-nm"
	rm -f ${CROSS_DIR}/lib/gcc-lib/${TARGET_SYS}/${PV}/libgcc_eh.a
	(cd ${S} && gnu-configize) || die "failure running gnu-configize"
	oe_runconf
}

do_compile_prepend () {
	export CC="${BUILD_CC}"
	export AR_FOR_TARGET="${TARGET_SYS}-ar"
	export RANLIB_FOR_TARGET="${TARGET_SYS}-ranlib"
	export LD_FOR_TARGET="${TARGET_SYS}-ld"
	export NM_FOR_TARGET="${TARGET_SYS}-nm"
	export CC_FOR_TARGET="${CCACHE} ${TARGET_SYS}-gcc"
}

do_stage_append () {
	for d in info man share/doc share/locale ; do
		rm -rf ${CROSS_DIR}/$d
	done

	# Fix a few include links so cross builds are happier
	if [ ! -e ${STAGING_INCDIR}/c++ ]; then
		mkdir -p ${STAGING_INCDIR}
		rm -f ${STAGING_INCDIR}/c++
		ln -sf ${CROSS_DIR}/${TARGET_SYS}/include/c++ \
			${STAGING_INCDIR}/
	fi

	# We use libiberty from binutils
	rm -f ${CROSS_DIR}/lib/libiberty.a

	# We probably don't need these
	rmdir ${CROSS_DIR}/include || :

	# We don't really need to keep this around
	rm -rf ${CROSS_DIR}/share
}
