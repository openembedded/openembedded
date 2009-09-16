#
# Creates a root filesystem out of IPKs
#
# This rootfs can be mounted via root-nfs or it can be put into an cramfs/jffs etc.
# See image.bbclass for a usage of this.
#

do_rootfs[depends] += "opkg-native:do_populate_staging"

IPKG_TMP_DIR = "${IMAGE_ROOTFS}-tmp"
IPKG_ARGS = "-f ${IPKGCONF_TARGET} -o ${IMAGE_ROOTFS} -t ${IPKG_TMP_DIR} ${@base_conditional("PACKAGE_INSTALL_NO_DEPS", "1", "-nodeps", "", d)}"

PACKAGE_INSTALL_NO_DEPS ?= "0"

# What support to provide for online management of packages at run time?
#  full -> traditional system, opkg is installed with all metadata
#  add -> opkg is installed with basic conf files but no status database; can add new packages at runtime but not modify existing ones
#  none -> opkg not installed at all, no metadata or config files provided
ONLINE_PACKAGE_MANAGEMENT ?= "full"

# Which packages to not install on the basis of a recommendation
BAD_RECOMMENDATIONS ?= ""

IPKG_VARIANT ?= "opkg"

RDEPENDS_append = " ${@base_conditional("ONLINE_PACKAGE_MANAGEMENT", "none", "", "${IPKG_VARIANT} opkg-collateral", d)}"
PACKAGE_INSTALL_append = " ${@base_conditional("ONLINE_PACKAGE_MANAGEMENT", "none", "", "${IPKG_VARIANT} opkg-collateral", d)}"

fakeroot rootfs_ipk_do_rootfs () {
	set -x

	package_generate_ipkg_conf

	mkdir -p ${T}
	mkdir -p ${IPKG_TMP_DIR}
	mkdir -p ${IMAGE_ROOTFS}${libdir}/opkg/

	STATUS=${IMAGE_ROOTFS}${libdir}/opkg/status
	# prime the status file with bits that we don't want
	for i in ${BAD_RECOMMENDATIONS}; do
		echo "Package: $i" >> $STATUS
		echo "Architecture: ${TARGET_ARCH}" >> $STATUS
		echo "Status: deinstall ok not-installed" >> $STATUS
		echo >> $STATUS
	done

	opkg-cl ${IPKG_ARGS} update

	# Uclibc builds don't provide this stuff...
	if [ x${TARGET_OS} = "xlinux" ] || [ x${TARGET_OS} = "xlinux-gnueabi" ] ; then 
		if [ ! -z "${LINGUAS_INSTALL}" ]; then
			opkg-cl ${IPKG_ARGS} install glibc-localedata-i18n
			for i in ${LINGUAS_INSTALL}; do
				opkg-cl ${IPKG_ARGS} install $i 
			done
		fi
	fi
	if [ ! -z "${PACKAGE_INSTALL}" ]; then
		opkg-cl ${IPKG_ARGS} install ${PACKAGE_INSTALL}
	fi

	export D=${IMAGE_ROOTFS}
	export OFFLINE_ROOT=${IMAGE_ROOTFS}
	export IPKG_OFFLINE_ROOT=${IMAGE_ROOTFS}
	export OPKG_OFFLINE_ROOT=${IPKG_OFFLINE_ROOT}
	
	if [ "${ONLINE_PACKAGE_MANAGEMENT}" != "none" ]; then
        	mkdir -p ${IMAGE_ROOTFS}${sysconfdir}/opkg/
		grep "^arch" ${IPKGCONF_TARGET} >${IMAGE_ROOTFS}${sysconfdir}/opkg/arch.conf
	fi

	for i in ${IMAGE_ROOTFS}${libdir}/opkg/info/*.preinst; do
		if [ -f $i ] && ! sh $i; then
			opkg-cl ${IPKG_ARGS} flag unpacked `basename $i .preinst`
		fi
	done
	for i in ${IMAGE_ROOTFS}${libdir}/opkg/info/*.postinst; do
		if [ -f $i ] && ! sh $i configure; then
			opkg-cl ${IPKG_ARGS} flag unpacked `basename $i .postinst`
		fi
	done

	install -d ${IMAGE_ROOTFS}/${sysconfdir}
	echo ${BUILDNAME} > ${IMAGE_ROOTFS}/${sysconfdir}/version
	
	${ROOTFS_POSTPROCESS_COMMAND}

	if [ "${ONLINE_PACKAGE_MANAGEMENT}" != "none" ]; then
		if [ "${ONLINE_PACKAGE_MANAGEMENT}" == "add" ]; then
			rm -f ${IMAGE_ROOTFS}${libdir}/opkg/status
			rm -f ${IMAGE_ROOTFS}${libdir}/opkg/*/*
		else
			rm -f ${IMAGE_ROOTFS}${libdir}/opkg/lists/*
		fi
	
		# Keep these lines until package manager selection is implemented
		ln -s opkg ${IMAGE_ROOTFS}${sysconfdir}/ipkg
		ln -s opkg ${IMAGE_ROOTFS}${libdir}/ipkg
	else
		rm -rf ${IMAGE_ROOTFS}${libdir}/opkg
		rm -rf ${IMAGE_ROOTFS}/usr/lib/opkg
	fi
	
	log_check rootfs 	
	rm -rf ${IPKG_TMP_DIR}
}

rootfs_ipk_log_check() {
	target="$1"
        lf_path="$2"

	lf_txt="`cat $lf_path`"
	for keyword_die in "Cannot find package" "Cannot satisfy the following dependencies" \
	    "exit 1" ERR Fail
	do				
		if (echo "$lf_txt" | grep -v log_check | grep -w "$keyword_die") >/dev/null 2>&1
		then
			echo "log_check: There were error messages in the logfile"
			printf "log_check: Matched keyword: [$keyword_die]\n"
			echo "$lf_txt" | grep -v log_check | grep -i "$keyword_die" -C1
			echo ""
			do_exit=1				
		fi
	done
	test "$do_exit" = 1 && exit 1
	true
}

remove_packaging_data_files() {
	rm -rf ${IMAGE_ROOTFS}${libdir}/opkg/
}
