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

PACKAGES_append_multilib = " libgcc-${ARCH_MULTILIB} libssp-${ARCH_MULTILIB} libstdc++-${ARCH_MULTILIB} libg2c-${ARCH_MULTILIB} libgfortran-${ARCH_MULTILIB}"
FILES_libgcc-${ARCH_MULTILIB} = "${layout_base_prefix}/${LIB_MULTILIB}/libgcc_s.so.1"
FILES_libssp-${ARCH_MULTILIB} = "${layout_exec_prefix}/${LIB_MULTILIB}/libssp.so.*"
FILES_libstdc++-${ARCH_MULTILIB} = "${layout_exec_prefix}/${LIB_MULTILIB}/libstdc++.so.*"
FILES_libg2c-${ARCH_MULTILIB} = "${layout_exec_prefix}/${LIB_MULTILIB}/libg2c.so.*"
FILES_libgfortran-${ARCH_MULTILIB} = "${layout_exec_prefix}/${LIB_MULTILIB}/libgfortran.so.*"

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
                mv -f ${D}${prefix}/*/lib/libgcc_s.so* ${D}${target_base_libdir} || true 
        fi



	# Move libstdc++ and libg2c into libdir (resetting our prefix to /usr
        mkdir -p ${D}${target_libdir}

        if [ -f ${D}${prefix}/*/lib/nof/libstdc++.so ]; then

           mv -f ${D}${prefix}/*/lib/nof/libstdc++.so* ${D}${target_libdir} || true
           mv -f ${D}${prefix}/*/lib/nof/libg2c.so* ${D}${target_libdir} || true
           mv -f ${D}${prefix}/*/lib/nof/libgfortran*.so* ${D}${target_libdir} || true
           mv -f ${D}${prefix}/*/lib/nof/libssp*.so* ${D}${target_libdir} || true 	

        else
           mv -f ${D}${prefix}/*/lib/libstdc++.so* ${D}${target_libdir} || true
           mv -f ${D}${prefix}/*/lib/libg2c.so* ${D}${target_libdir} || true
           mv -f ${D}${prefix}/*/lib/libgfortran*.so* ${D}${target_libdir} || true
           mv -f ${D}${prefix}/*/lib/libssp*.so* ${D}${target_libdir} || true
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
       if [ -f ${CROSS_DIR}/bin/${TARGET_PREFIX}gfortran ]; then
              currdir="$PWD"
              cd ${CROSS_DIR}/bin/
              ln -sf ${TARGET_PREFIX}gfortran ${TARGET_PREFIX}g77 || true
              cd ${CROSS_DIR}/${TARGET_SYS}/bin/
              ln -sf gfortran g77 || true
              cd $currdir
       fi
}

do_install_append_multilib () {
	mkdir -p ${D}${base_multilibdir}
        if [ -f ${D}${base_multilibdir}/libgcc_s.so.? ]; then
                # Already in the right location
                :
        elif [ -f ${D}${prefix}/${LIB_MULTILIB}/libgcc_s.so.? ]; then
                mv -f ${D}${prefix}/${LIB_MULTILIB}/libgcc_s.so* ${D}${base_multilibdir} || true
        else
                mv -f ${D}${prefix}/*/${LIB_MULTILIB}/libgcc_s.so* ${D}${base_multilibdir} || true 
        fi

        mkdir -p ${D}${multilibdir}

        mv -f ${D}${prefix}/*/${LIB_MULTILIB}/libstdc++.so* ${D}${multilibdir} || true
        mv -f ${D}${prefix}/*/${LIB_MULTILIB}/libg2c.so* ${D}${multilibdir} || true
        mv -f ${D}${prefix}/*/${LIB_MULTILIB}/libgfortran*.so* ${D}${multilibdir} || true
        mv -f ${D}${prefix}/*/${LIB_MULTILIB}/libssp*.so* ${D}${multilibdir} || true

        # Manually run the target stripper since we won't get it run by
        # the packaging.
        if [ "x${OLD_INHIBIT_PACKAGE_STRIP}" != "x1" ]; then
                ${TARGET_PREFIX}strip ${D}${multilibdir}/libstdc++.so.*
                ${TARGET_PREFIX}strip ${D}${multilibdir}/libg2c.so.* || true
                ${TARGET_PREFIX}strip ${D}${base_multilibdir}/libgcc_s.so.* || true
                ${TARGET_PREFIX}strip ${D}${multilibdir}/libgfortran*.so* || true
	fi
}
