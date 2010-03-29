INHIBIT_PACKAGE_STRIP ?= ""
OLD_INHIBIT_PACKAGE_STRIP := "${INHIBIT_PACKAGE_STRIP}"
INHIBIT_PACKAGE_STRIP = "1"

PACKAGES = "libgcc libssp libstdc++ libg2c libgfortran"

# Called from within gcc-cross, so libdir is set wrong
FILES_libg2c = "${target_libdir}/libg2c.so.*"

FILES_libssp = "${target_libdir}/libssp.so.*"

FILES_libgfortran = "${target_libdir}/libgfortran.so.*"

FILES_libgcc = "${target_base_libdir}/libgcc_s.so.1"

FILES_libstdc++ = "${target_libdir}/libstdc++.so.*"

do_install () {
	oe_runmake 'DESTDIR=${D}' install

	# Move libgcc_s into /lib
        mkdir -p ${D}${target_base_libdir}
        if [ -f ${D}${target_base_libdir}/libgcc_s.so.? ]; then
                # Already in the right location
                :
        elif [ -f ${D}${prefix}/lib/libgcc_s.so.? ]; then
                mv -f ${D}${prefix}/lib/libgcc_s.so* ${D}${target_base_libdir} || true

        elif [  -f ${D}${prefix}/*/lib/nof/libgcc_s.so.? ]; then
                mv -f ${D}${prefix}/*/lib/nof/libgcc_s.so* ${D}${target_base_libdir}
        else
                # Look for .../${TARGET_SYS}/lib/libgcc_s*
                # (or /lib64/, on x86_64)
                mv -f ${D}${prefix}/*/${target_base_libdir}/libgcc_s.so* ${D}${target_base_libdir} || true 
        fi



	# Move libstdc++ and libg2c into libdir (resetting our prefix to /usr
        mkdir -p ${D}${target_libdir}

        if [ -f ${D}${prefix}/*/lib/nof/libstdc++.so ]; then

           mv -f ${D}${prefix}/*/lib/nof/libstdc++.so* ${D}${target_libdir} || true
           mv -f ${D}${prefix}/*/lib/nof/libg2c.so* ${D}${target_libdir} || true
           mv -f ${D}${prefix}/*/lib/nof/libgfortran*.so* ${D}${target_libdir} || true
           mv -f ${D}${prefix}/*/lib/nof/libssp*.so* ${D}${target_libdir} || true 	

        else
           # Look for .../${TARGET_SYS}/lib/lib* (or /lib64/ on x86_64)
           mv -f ${D}${prefix}/*/${target_base_libdir}/libstdc++.so* ${D}${target_libdir} || true
           mv -f ${D}${prefix}/*/${target_base_libdir}/libg2c.so* ${D}${target_libdir} || true
           mv -f ${D}${prefix}/*/${target_base_libdir}/libgfortran*.so* ${D}${target_libdir} || true
           mv -f ${D}${prefix}/*/${target_base_libdir}/libssp*.so* ${D}${target_libdir} || true
        fi



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
       if [ -f ${D}${CROSS_DIR}/bin/${TARGET_PREFIX}gfortran ]; then
              currdir="$PWD"
              cd ${D}${CROSS_DIR}/bin/
              ln -sf ${TARGET_PREFIX}gfortran ${TARGET_PREFIX}g77 || true
              if [ -d ${CROSS_DIR}/${TARGET_SYS}/bin/ ] ; then 
                  cd ${CROSS_DIR}/${TARGET_SYS}/bin/
                  ln -sf gfortran g77 || true
              fi
              cd $currdir
        fi
}
