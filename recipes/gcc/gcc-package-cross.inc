PACKAGE_STRIP ?= ""
OLD_PACKAGE_STRIP := "${PACKAGE_STRIP}"
PACKAGE_STRIP = "no"

SHLIBSDIR = "${STAGING_DIR_TARGET}/shlibs"

PACKAGES = "libgcc libssp libstdc++ libg2c libgfortran"

# Called from within gcc-cross, so libdir is set wrong
FILES_libg2c = "${target_libdir}/libg2c.so.*"

FILES_libssp = "${target_libdir}/libssp.so.*"

FILES_libgfortran = "${target_libdir}/libgfortran.so.*"

FILES_libgcc = "${target_base_libdir}/libgcc_s.so.1"
FILES_libgcc-dev = "${target_libdir}/libgcc_s.so"

FILES_libstdc++ = "${target_libdir}/libstdc++.so.*"

do_install () {
	oe_runmake 'DESTDIR=${D}' install
	install -d ${D}${target_base_libdir}
	install -d ${D}${target_libdir}

	for d in ${TARGET_SYS}/lib/nof ${TARGET_SYS}/lib64 ${TARGET_SYS}/lib; do
		if [ -d ${D}${prefix}/$d/ ]; then
			mv -f ${D}${prefix}/$d/libgcc* ${D}${target_base_libdir} || true
			mv -f ${D}${prefix}/$d/* ${D}${target_libdir} || true
		fi
	done
	rm -f ${D}${target_base_libdir}/libgcc_s.so
	rm -f ${D}${target_libdir}/libgcc_s.so
       echo "/* GNU ld script
   Use the shared library, but some functions are only in
   the static library.  */
GROUP ( libgcc_s.so.1 libgcc.a )" > ${D}${target_libdir}/libgcc_s.so

	# since we are moving the .la files to target sysroot we need to make sure that
	# libdir points to right place within the target sysroot
	for la in ${D}${target_libdir}/libstdc++.la ${D}${target_libdir}/libsupc++.la; do
		if [ -f $la ]; then
			sed -i -e "s:^libdir=.*:libdir='${target_libdir}':g;" $la
		fi
	done

	# Manually run the target stripper since we won't get it run by
	# the packaging.
	if [ "x${OLD_INHIBIT_PACKAGE_STRIP}" != "x1" ]; then
		${TARGET_PREFIX}strip ${D}${target_libdir}/libstdc++.so.* || true
		${TARGET_PREFIX}strip ${D}${target_libdir}/libg2c.so.* || true
		${TARGET_PREFIX}strip ${D}${target_base_libdir}/libgcc_s.so.* || true
		${TARGET_PREFIX}strip ${D}${target_libdir}/libgfortran*.so* || true
	fi

	# Link gfortran to g77 to satisfy not-so-smart configure or hard coded g77
	# gfortran is fully backwards compatible. This is a safe and practical solution.
	if [ -f ${D}${TOOLCHAIN_PATH}/bin/${TARGET_PREFIX}gfortran ]; then
		currdir="$PWD"
		cd ${D}${TOOLCHAIN_PATH}/bin/
		ln -sf ${TARGET_PREFIX}gfortran ${TARGET_PREFIX}g77 || true
		if [ -d ${TOOLCHAIN_PATH}/${TARGET_SYS}/bin/ ] ; then
			cd ${TOOLCHAIN_PATH}/${TARGET_SYS}/bin/
			ln -sf gfortran g77 || true
		fi
		cd $currdir
	fi
	# We use libiberty from binutils or binutils-cross
	rm -f ${D}${libdir}/libiberty.a
	rm -f ${D}${target_libdir}/libiberty.a
}

