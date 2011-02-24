#
# Copyright 2006-2007 Openedhand Ltd.
#
ROOTFS_PKGMANAGE = "run-postinsts dpkg"
ROOTFS_PKGMANAGE_BOOTSTRAP  = "run-postinsts"

do_rootfs[depends] += "dpkg-native:do_populate_sysroot apt-native:do_populate_sysroot"
do_rootfs[recrdeptask] += "do_package_write_deb"

fakeroot rootfs_deb_do_rootfs () {
	set +e
	mkdir -p ${IMAGE_ROOTFS}/var/lib/dpkg/info
	mkdir -p ${IMAGE_ROOTFS}/var/lib/dpkg/updates

	rm -f ${STAGING_ETCDIR_NATIVE}/apt/sources.list.rev
	rm -f ${STAGING_ETCDIR_NATIVE}/apt/preferences
	> ${IMAGE_ROOTFS}/var/lib/dpkg/status
	> ${IMAGE_ROOTFS}/var/lib/dpkg/available
	mkdir -p ${IMAGE_ROOTFS}/var/lib/dpkg/alternatives

	priority=1
	for arch in ${PACKAGE_ARCHS}; do
		if [ ! -d ${DEPLOY_DIR_DEB}/$arch ]; then
			continue;
		fi
		cd ${DEPLOY_DIR_DEB}/$arch

		echo "Label: $arch" > Release

		echo "deb file:${DEPLOY_DIR_DEB}/$arch/ ./" >> ${STAGING_ETCDIR_NATIVE}/apt/sources.list.rev
		(echo "Package: *"
		echo "Pin: release l=$arch"
		echo "Pin-Priority: $(expr 800 + $priority)"
		echo) >> ${STAGING_ETCDIR_NATIVE}/apt/preferences
		priority=$(expr $priority + 5)
	done

	tac ${STAGING_ETCDIR_NATIVE}/apt/sources.list.rev > ${STAGING_ETCDIR_NATIVE}/apt/sources.list

	cat "${STAGING_ETCDIR_NATIVE}/apt/apt.conf.sample" \
		| sed -e 's#Architecture ".*";#Architecture "${DPKG_ARCH}";#' \
	        | sed -e 's#status ".*";#status "${IMAGE_ROOTFS}/var/lib/dpkg/status";#' \
		| sed -e 's#DPkg::Options {".*"};#DPkg::Options {"--root=${IMAGE_ROOTFS}";"--admindir=${IMAGE_ROOTFS}/var/lib/dpkg";"--force-all";"--no-debsig"};#' \
		> "${STAGING_ETCDIR_NATIVE}/apt/apt-rootfs.conf"

	export APT_CONFIG="${STAGING_ETCDIR_NATIVE}/apt/apt-rootfs.conf"
	export D=${IMAGE_ROOTFS}
	export OFFLINE_ROOT=${IMAGE_ROOTFS}
	export IPKG_OFFLINE_ROOT=${IMAGE_ROOTFS}
	export OPKG_OFFLINE_ROOT=${IMAGE_ROOTFS}

	apt-get update

	_flag () {
		sed -i -e "/^Package: $2\$/{n; s/Status: install ok .*/Status: install ok $1/;}" ${IMAGE_ROOTFS}/var/lib/dpkg/status
	}
	_getflag () {
		cat ${IMAGE_ROOTFS}/var/lib/dpkg/status | sed -n -e "/^Package: $2\$/{n; s/Status: install ok .*/$1/; p}"
	}

	if [ x${TARGET_OS} = "xlinux" ] || [ x${TARGET_OS} = "xlinux-gnueabi" ] ; then
		if [ ! -z "${LINGUAS_INSTALL}" ]; then
			apt-get install glibc-localedata-i18n --force-yes --allow-unauthenticated
			if [ $? -ne 0 ]; then
				exit 1
			fi
			for i in ${LINGUAS_INSTALL}; do
				apt-get install $i --force-yes --allow-unauthenticated
				if [ $? -ne 0 ]; then
					exit 1
				fi
			done
		fi
	fi

	if [ ! -z "${PACKAGE_INSTALL}" ]; then
		for i in ${PACKAGE_INSTALL}; do
			apt-get install $i --force-yes --allow-unauthenticated
			if [ $? -ne 0 ]; then
				exit 1
			fi
		done
	fi

	rm ${WORKDIR}/temp/log.do_$target-attemptonly.${PID}
	if [ ! -z "${PACKAGE_INSTALL_ATTEMPTONLY}" ]; then
		for i in ${PACKAGE_INSTALL_ATTEMPTONLY}; do
			apt-get install $i --force-yes --allow-unauthenticated >> ${WORKDIR}/temp/log.do_rootfs-attemptonly.${PID} || true
		done
	fi

	find ${IMAGE_ROOTFS} -name \*.dpkg-new | for i in `cat`; do
		mv $i `echo $i | sed -e's,\.dpkg-new$,,'`
	done

	install -d ${IMAGE_ROOTFS}/${sysconfdir}
	echo ${BUILDNAME} > ${IMAGE_ROOTFS}/${sysconfdir}/version

	# Mark all packages installed
	sed -i -e "s/Status: install ok unpacked/Status: install ok installed/;" ${IMAGE_ROOTFS}/var/lib/dpkg/status

	# Attempt to run preinsts
	# Mark packages with preinst failures as unpacked
	for i in ${IMAGE_ROOTFS}/var/lib/dpkg/info/*.preinst; do
		if [ -f $i ] && ! sh $i; then
			_flag unpacked `basename $i .preinst`
		fi
	done

	# Attempt to run postinsts
	# Mark packages with postinst failures as unpacked
	for i in ${IMAGE_ROOTFS}/var/lib/dpkg/info/*.postinst; do
		if [ -f $i ] && ! sh $i configure; then
			_flag unpacked `basename $i .postinst`
		fi
	done

	set -e

	# Hacks to allow opkg's update-alternatives and opkg to coexist for now
	mkdir -p ${IMAGE_ROOTFS}${libdir}/opkg/alternatives
	if [ -e ${IMAGE_ROOTFS}/var/lib/dpkg/alternatives ]; then
		mv ${IMAGE_ROOTFS}/var/lib/dpkg/alternatives/* ${IMAGE_ROOTFS}${libdir}/opkg/alternatives/
		rmdir ${IMAGE_ROOTFS}/var/lib/dpkg/alternatives
	fi
	ln -s ${libdir}/opkg/alternatives ${IMAGE_ROOTFS}/var/lib/dpkg/alternatives
	ln -s /var/lib/dpkg/info ${IMAGE_ROOTFS}${libdir}/opkg/info
	ln -s /var/lib/dpkg/status ${IMAGE_ROOTFS}${libdir}/opkg/status

	${ROOTFS_POSTPROCESS_COMMAND}

	log_check rootfs
}

rootfs_deb_log_check() {
	target="$1"
        lf_path="$2"

	lf_txt="`cat $lf_path`"
	for keyword_die in "E:"
	do
		if (echo "$lf_txt" | grep -v log_check | grep "$keyword_die") >/dev/null 2>&1
		then
			echo "log_check: There were error messages in the logfile"
			echo -e "log_check: Matched keyword: [$keyword_die]\n"
			echo "$lf_txt" | grep -v log_check | grep -C 5 -i "$keyword_die"
			echo ""
			do_exit=1
		fi
	done
	test "$do_exit" = 1 && exit 1
	true
}

remove_packaging_data_files() {
	rm -rf ${IMAGE_ROOTFS}${libdir}/opkg/
	rm -rf ${IMAGE_ROOTFS}/usr/dpkg/
}
