PACKAGE_STRIP ?= ""
OLD_PACKAGE_STRIP := "${PACKAGE_STRIP}"
PACKAGE_STRIP = "no"

# Having anything auto depending on gcc-cross-sdk is a really bad idea...
EXCLUDE_FROM_SHLIBS = "1"

PACKAGES = "${PN} ${PN}-doc"

FILES_${PN} = "\
    ${bindir}/* \
    ${libexecdir}/gcc/${TARGET_SYS}/${BINV}/cc1${EXEEXT} \
    ${libexecdir}/gcc/${TARGET_SYS}/${BINV}/collect2${EXEEXT} \
    ${libexecdir}/gcc/${TARGET_SYS}/${BINV}/f771${EXEEXT} \
    ${libexecdir}/gcc/${TARGET_SYS}/${BINV}/cc1plus${EXEEXT} \
    ${gcclibdir}/${TARGET_SYS}/${BINV}/*.o \
    ${gcclibdir}/${TARGET_SYS}/${BINV}/specs \
    ${gcclibdir}/${TARGET_SYS}/${BINV}/lib* \
    ${gcclibdir}/${TARGET_SYS}/${BINV}/include* \
    ${includedir}/c++/${BINV} \
    ${prefix}/${TARGET_SYS}/bin/* \
    ${prefix}/${TARGET_SYS}/lib/* \
    ${prefix}/${TARGET_SYS}/usr/include/* \
    "
FILES_${PN}-doc = "\
    ${infodir} \
    ${mandir} \
    ${gcclibdir}/${TARGET_SYS}/${BINV}/include/README \
    "

do_install () {
	oe_runmake 'DESTDIR=${D}' install

	# Cleanup some of the ${libdir}{,exec}/gcc stuff ...
	rm -r ${D}${libdir}/gcc/${TARGET_SYS}/${BINV}/install-tools
	rm -r ${D}${libexecdir}/gcc/${TARGET_SYS}/${BINV}/install-tools

	# We care about g++ not c++
	rm -f ${D}${bindir}/*c++${EXEEXT}

	# We don't care about the gcc-<version> copies
	rm -f ${D}${bindir}/*gcc-?.?*${EXEEXT}

	# We use libiberty from binutils
	rm -f ${D}${prefix}/${TARGET_SYS}/lib/libiberty.a
	rm -f ${D}${libdir}/libiberty.a

	# Create the ${prefix}/${TARGET_SYS}/bin/* symlinks
	install -d ${D}${prefix}/${TARGET_SYS}/bin/
	for l in ${D}${bindir}/*; do
		ln -sf "../../`basename ${bindir}`/`basename $l`" "${D}${prefix}/${TARGET_SYS}/bin/`basename $l | sed -e 's,${TARGET_PREFIX},,'`"
	done
	ln -sf "../../`basename ${bindir}`/${TARGET_PREFIX}gcc${EXEEXT}" "${D}${prefix}/${TARGET_SYS}/bin/cc${EXEEXT}"

	# Manually run the target stripper since we won't get it run by
	# the packaging.
	if [ "x${OLD_PACKAGE_STRIP}" != "xno" ]; then
		for soFile in ${D}${prefix}/${TARGET_SYS}/lib/libstdc++.so.* ${D}${prefix}/${TARGET_SYS}/lib/libg2c.so.* ${D}${prefix}/${TARGET_SYS}/lib/libgcc_s.so.*; do
			if echo ${soFile} | grep '.py$' ; then
				echo "Not stripping .py file ${soFile}"
			elif echo ${soFile} | grep '*' ; then
				echo "Not stripping non-existent mask ${soFile}"
			else
				${TARGET_PREFIX}strip ${soFile}
			fi
		done
	fi
}
