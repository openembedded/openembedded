PACKAGESTRIPFUNCS += "do_strip_modules"

# inherit to get get_kernelmajorversion();
inherit linux-kernel-base

# may be inherited by kernel.bbclass which sets KERNEL_MAJOR_VERSION
KERNEL_MAJOR_VERSION ?= "${@get_kernelmajorversion('${KERNEL_VERSION}')}"

do_strip_modules () {
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
		fi
	fi
}


