require gcc-configure-common.inc

USE_NLS = '${@base_conditional( "TARGET_OS", "linux-uclibc", "no", "", d )}'

EXTRA_OECONF_PATHS = "--with-local-prefix=${STAGING_DIR_TARGET}${target_prefix} \
		      --with-gxx-include-dir=${STAGING_DIR_TARGET}/${target_includedir}/c++ \
                      --with-sysroot=${STAGING_DIR_TARGET} \
                      --with-build-sysroot=${STAGING_DIR_TARGET}"

do_configure_prepend () {
	export CC="${BUILD_CC}"
	export AR_FOR_TARGET="${TARGET_SYS}-ar"
	export AS_FOR_TARGET="${TARGET_SYS}-as"
	export RANLIB_FOR_TARGET="${TARGET_SYS}-ranlib"
	export LD_FOR_TARGET="${TARGET_SYS}-ld"
	export NM_FOR_TARGET="${TARGET_SYS}-nm"
	export OBJDUMP_FOR_TARGET="${TARGET_SYS}-objdump"
	export OBJCOPY_FOR_TARGET="${TARGET_SYS}-objcopy"
	export STRIP_FOR_TARGET="${TARGET_SYS}-strip"
	export CC_FOR_TARGET="${CCACHE} ${TARGET_SYS}-gcc ${TARGET_CC_ARCH}"
}

LIBGCCS_VAR = "-lgcc_s"
LIBGCCS_VAR_avr32 = ""

do_stage_append () {
	for d in info man share/doc share/locale ; do
		rm -rf ${CROSS_DIR}/$d
	done

	# Fix a few include links so cross builds are happier
	if [ ! -e ${STAGING_INCDIR}/c++ ]; then
		mkdir -p ${STAGING_INCDIR}
		mkdir -p ${CROSS_DIR}/${TARGET_SYS}/include/c++
		ln -sf ${CROSS_DIR}/${TARGET_SYS}/include/c++ \
			${STAGING_INCDIR}/
	fi

	# We probably don't need these
	rmdir ${CROSS_DIR}/include || :

	# We don't really need to keep this around
	# rm -rf ${CROSS_DIR}/share but leave java there
	for d in share/man share/info;
	do
		rm -rf ${CROSS_DIR}/$d
	done

	#fix up libsupc++ and libstdc++ la files
	for d in lib lib/nof; do
		sed -i "s|dependency_libs\s*=\s*.*|dependency_libs='-L${CROSS_DIR}/${TARGET_SYS}/$d ${LIBGCCS_VAR} -lc -lm '|" ${CROSS_DIR}/${TARGET_SYS}/$d/libsupc++.la || true
		sed -i "s|dependency_libs\s*=\s*.*|dependency_libs='-L${CROSS_DIR}/${TARGET_SYS}/$d ${LIBGCCS_VAR} -lc -lm '|" ${CROSS_DIR}/${TARGET_SYS}/$d/libstdc++.la || true
	done

    # Link gfortran to g77 to satisfy not-so-smart configure or hard coded g77
    # gfortran is fully backwards compatible. This is a safe and practical solution.
    if [ -f ${CROSS_DIR}/bin/${TARGET_PREFIX}gfortran ]; then
           currdir="$PWD"
           cd ${CROSS_DIR}/bin/
           ln -sf ${TARGET_PREFIX}gfortran ${TARGET_PREFIX}g77 || true
           if [ -d ${CROSS_DIR}/${TARGET_SYS}/bin/ ] ; then 
               cd ${CROSS_DIR}/${TARGET_SYS}/bin/
               ln -sf gfortran g77 || true
           fi
           cd $currdir
    fi
}

