#DEPENDS_append = " module-strip"

do_strip_modules () {
	for p in ${PACKAGES}; do
		if test -e ${PKGDEST}/$p/lib/modules; then
			if [ "${KERNEL_MAJOR_VERSION}" == "2.6" ]; then
				modules="`find ${PKGDEST}/${p}/lib/modules -name \*.ko`"
			else
				modules="`find ${PKGDEST}/${p}/lib/modules -name \*.o`"
			fi
			if [ -n "$modules" ]; then
				for module in $modules ; do
					if ! [ -d "$module"  ] ; then
						${STRIP} -v -g $module
					fi
				done	
#				NM="${CROSS_DIR}/bin/${HOST_PREFIX}nm" OBJCOPY="${CROSS_DIR}/bin/${HOST_PREFIX}objcopy" strip_module $modules
			fi
		fi
	done
}

python do_package_append () {
	if (bb.data.getVar('INHIBIT_PACKAGE_STRIP', d, 1) != '1'):
		bb.build.exec_func('do_strip_modules', d)
}
