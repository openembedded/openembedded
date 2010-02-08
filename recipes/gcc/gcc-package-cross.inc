INHIBIT_PACKAGE_STRIP ?= ""
OLD_INHIBIT_PACKAGE_STRIP := "${INHIBIT_PACKAGE_STRIP}"
INHIBIT_PACKAGE_STRIP = "1"

PACKAGES += "libgcc libssp libstdc++ libg2c libgfortran"

# Called from within gcc-cross, so libdir is set wrong
FILES_libg2c = "${target_libdir}/libg2c.so.*"

FILES_libssp = "${target_libdir}/libssp.so.*"

FILES_libgfortran = "${target_libdir}/libgfortran.so.*"

FILES_libgcc = "${target_base_libdir}/libgcc_s.so.1"

FILES_libstdc++ = "${target_libdir}/libstdc++.so.*"

do_install () {
	oe_runmake 'DESTDIR=${D}' install

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
