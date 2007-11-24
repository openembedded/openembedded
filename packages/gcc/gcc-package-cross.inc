# Packages emitted by our gcc-cross builds.
#
INHIBIT_PACKAGE_STRIP ?= ""
OLD_INHIBIT_PACKAGE_STRIP := "${INHIBIT_PACKAGE_STRIP}"
INHIBIT_PACKAGE_STRIP = "1"

PACKAGES = "libgcc libgcc-dev libstdc++ libg2c libg2c-dev libgfortran libgfortran-dev"

# Called from within gcc-cross, so libdir is set wrong
FILES_libg2c = "${target_libdir}/libg2c.so.*"
FILES_libg2c-dev = "${target_libdir}/libg2c.so \
		    ${target_libdir}/libg2c.a \
		    ${target_libdir}/libfrtbegin.a"

FILES_libgfortran = "${target_libdir}/libgfortran.so.*"
FILES_libgfortran-dev = "${target_libdir}/libgfortran.a \
			 ${target_libdir}/libgfortran.so \
			 ${target_libdir}/libgfortranbegin.a"

FILES_libgcc = "${target_base_libdir}/libgcc_s.so.1"
FILES_libgcc-dev = "${target_base_libdir}/libgcc_s.so"

FILES_libstdc++ = "${target_libdir}/libstdc++.so.*"
FILES_libstdc++-dev = "${target_includedir}/c++/${PV} \
		       ${target_libdir}/libstdc++.so \
		       ${target_libdir}/libstdc++.la \
		       ${target_libdir}/libstdc++.a \
		       ${target_libdir}/libsupc++.la \
		       ${target_libdir}/libsupc++.a"

python do_package() {
	if bb.data.getVar('DEBIAN_NAMES', d, 1):
		bb.data.setVar('PKG_libgcc', 'libgcc1', d)
	bb.build.exec_func('package_do_package', d)
}

do_install () {
	oe_runmake 'DESTDIR=${D}' install

  # Move libgcc_s into /lib
        mkdir -p ${D}${target_base_libdir}
        if [ -f ${D}${target_base_libdir}/libgcc_s.so.? ]; then
                # Already in the right location
                :
        elif [ -f ${D}${prefix}/lib/libgcc_s.so.? ]; then
                mv -f ${D}${prefix}/lib/libgcc_s.so* ${D}${target_base_libdir}

        elif [  -f ${D}${prefix}/*/lib/nof/libgcc_s.so.? ]; then
                mv -f ${D}${prefix}/*/lib/nof/libgcc_s.so* ${D}${target_base_libdir}
        else
                mv -f ${D}${prefix}/*/lib/libgcc_s.so* ${D}${target_base_libdir}
        fi



   # Move libstdc++ and libg2c into libdir (resetting our prefix to /usr
        mkdir -p ${D}${target_libdir}

        if [ -f ${D}${prefix}/*/lib/nof/libstdc++.so ]; then

           mv -f ${D}${prefix}/*/lib/nof/libstdc++.so* ${D}${target_libdir}
           mv -f ${D}${prefix}/*/lib/nof/libg2c.so* ${D}${target_libdir} || true
           mv -f ${D}${prefix}/*/lib/nof/libgfortran*.so* ${D}${target_libdir} || true

        else
           mv -f ${D}${prefix}/*/lib/libstdc++.so* ${D}${target_libdir}
           mv -f ${D}${prefix}/*/lib/libg2c.so* ${D}${target_libdir} || true
           mv -f ${D}${prefix}/*/lib/libgfortran*.so* ${D}${target_libdir} || true
        fi



       # Manually run the target stripper since we won't get it run by
       # the packaging.
       if [ "x${OLD_INHIBIT_PACKAGE_STRIP}" != "x1" ]; then
               ${TARGET_PREFIX}strip ${D}${target_libdir}/libstdc++.so.*
               ${TARGET_PREFIX}strip ${D}${target_libdir}/libg2c.so.* || true
               ${TARGET_PREFIX}strip ${D}${target_base_libdir}/libgcc_s.so.*
               ${TARGET_PREFIX}strip ${D}${target_libdir}/libgfortran*.so* || true
	fi
     
       # Link gfortran to g77 to satisfy not-so-smart configure or hard coded g77
       # gfortran is fully backwards compatible. This is a safe and practical solution. 
       ln -sf ${CROSS_DIR}/bin/${TARGET_PREFIX}gfortran ${CROSS_DIR}/bin/${TARGET_PREFIX}g77 || true
       ln -sf ${CROSS_DIR}/${TARGET_SYS}/bin/gfortran ${CROSS_DIR}/${TARGET_SYS}/bin/g77 || true
}
