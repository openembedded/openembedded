#DEPENDS_append = " module-strip"

do_strip_modules () {
	for p in ${PACKAGES}; do
		if test -e ${WORKDIR}/install/$p/lib/modules; then
			if [ "${KERNEL_MAJOR_VERSION}" == "2.6" ]; then
				modules="`find ${WORKDIR}/install/$p/lib/modules -name \*.ko`"
			else
				modules="`find ${WORKDIR}/install/$p/lib/modules -name \*.o`"
			fi
			if [ -n "$modules" ]; then
				for module in $modules ; do
					if ! [ -d "$module"  ] ; then
						${STRIP} -v -g $module
					fi
				done
#			      NM="${CROSS_DIR}/bin/${HOST_PREFIX}nm" OBJCOPY="${CROSS_DIR}/bin/${HOST_PREFIX}objcopy" strip_module $modules
			fi
		fi
	done
	if test -e ${PKGD}/lib/modules; then
		if [ "${KERNEL_MAJOR_VERSION}" == "2.6" ]; then
			modules="`find ${PKGD}/lib/modules -name \*.ko`"
		else
			modules="`find ${PKGD}/lib/modules -name \*.o`"
		fi
		if [ -n "$modules" ]; then
			for module in $modules ; do
				if ! [ -d "$module"  ] ; then
					${STRIP} -v -g $module
				fi
			done	
#			NM="${CROSS_DIR}/bin/${HOST_PREFIX}nm" OBJCOPY="${CROSS_DIR}/bin/${HOST_PREFIX}objcopy" strip_module $modules
		fi
	fi
}

do_deploy_stripped_modules () {
	if [ -d "${PKGD}/lib" ]; then
		fakeroot tar -cvzf ${DEPLOY_DIR_IMAGE}/${MODULES_IMAGE_BASE_NAME}.tgz -C ${PKGD} lib
	fi
}

python do_package_append () {
	if (bb.data.getVar('INHIBIT_PACKAGE_STRIP', d, 1) != '1'):
		bb.build.exec_func('do_strip_modules', d)
		bb.build.exec_func('do_deploy_stripped_modules', d)
}
