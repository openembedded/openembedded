DESCRIPTION = "Meta package for building a installable toolchain"
LICENSE = "MIT"
DEPENDS = "ipkg-native ipkg-utils-native fakeroot-native sed-native"

inherit sdk meta

SDK_DIR = "${WORKDIR}/sdk"
SDK_OUTPUT = "${SDK_DIR}/image"
SDK_DEPLOY = "${TMPDIR}/deploy/sdk"

FEED_ARCH ?= "${TARGET_ARCH}"

IPKG_HOST = "ipkg-cl -f ${IPKGCONF_SDK} -o ${SDK_OUTPUT}"
IPKG_TARGET = "ipkg-cl -f ${IPKGCONF_TARGET} -o ${SDK_OUTPUT}/${prefix}"

TOOLCHAIN_HOST_TASK ?= "task-sdk-host"
TOOLCHAIN_TARGET_TASK ?= "task-sdk-bare"

RDEPENDS = "${TOOLCHAIN_TARGET_TASK} ${TOOLCHAIN_HOST_TASK}"

do_populate_sdk() {
	rm -rf ${SDK_OUTPUT}
	mkdir -p ${SDK_OUTPUT}

	package_update_index_ipk
	package_generate_ipkg_conf

	for arch in ${PACKAGE_ARCHS}; do
		revipkgarchs="$arch $revipkgarchs"
	done

	${IPKG_HOST} update
	${IPKG_HOST} -force-depends install ${TOOLCHAIN_HOST_TASK}

	${IPKG_TARGET} update
	${IPKG_TARGET} install ${TOOLCHAIN_TARGET_TASK}

	mkdir -p ${SDK_OUTPUT}/${prefix}/${TARGET_SYS}
	cp -pPR ${SDK_OUTPUT}/${prefix}/usr/* ${SDK_OUTPUT}/${prefix}/${TARGET_SYS}
	rm -rf ${SDK_OUTPUT}/${prefix}/usr/

	cp -pPR ${SDK_OUTPUT}/${prefix}/lib/* ${SDK_OUTPUT}/${prefix}/${TARGET_SYS}/lib
	rm -rf ${SDK_OUTPUT}/${prefix}/lib/*

	for fn in `ls ${SDK_OUTPUT}/${prefix}/${TARGET_SYS}/lib/`; do
		if [ -h ${SDK_OUTPUT}/${prefix}/${TARGET_SYS}/lib/$fn ]; then
			link=`readlink ${SDK_OUTPUT}/${prefix}/${TARGET_SYS}/lib/$fn`
			bname=`basename $link`
			if [ ! -e $link -a -e ${SDK_OUTPUT}/${prefix}/${TARGET_SYS}/lib/$bame ]; then
				rm ${SDK_OUTPUT}/${prefix}/${TARGET_SYS}/lib/$fn
				ln -s $bname ${SDK_OUTPUT}/${prefix}/${TARGET_SYS}/lib/$fn
			fi
		fi
	done

	mv ${SDK_OUTPUT}/${prefix}/${TARGET_SYS}/lib/gcc ${SDK_OUTPUT}/${prefix}/lib

	echo 'GROUP ( libpthread.so.0 libpthread_nonshared.a )' > ${SDK_OUTPUT}/${prefix}/${TARGET_SYS}/lib/libpthread.so
	echo 'GROUP ( libc.so.6 libc_nonshared.a )' > ${SDK_OUTPUT}/${prefix}/${TARGET_SYS}/lib/libc.so

	# remove unwanted housekeeping files
	mv ${SDK_OUTPUT}${prefix}/${TARGET_SYS}/lib/ipkg/status ${SDK_OUTPUT}/${prefix}/package-status
	rm -Rf ${SDK_OUTPUT}${prefix}/${TARGET_SYS}/lib/ipkg
	mv ${SDK_OUTPUT}/usr/lib/ipkg/status ${SDK_OUTPUT}/${prefix}/package-status-host
	rm -Rf ${SDK_OUTPUT}/usr/lib

	# extract and store ipks, pkgdata and shlibs data
	target_pkgs=`cat ${SDK_OUTPUT}/${prefix}/package-status | grep Package: | cut -f 2 -d ' '`
	mkdir -p ${SDK_OUTPUT}/${prefix}/ipk/
	mkdir -p ${SDK_OUTPUT}/${prefix}/pkgdata/runtime/
	mkdir -p ${SDK_OUTPUT}/${prefix}/${TARGET_SYS}/shlibs/
	for pkg in $target_pkgs ; do
		for arch in $revipkgarchs; do
			pkgnames=${DEPLOY_DIR_IPK}/$arch/${pkg}_*_$arch.ipk
			if [ -e $pkgnames ]; then
				echo "Found $pkgnames"
				cp $pkgnames ${SDK_OUTPUT}/${prefix}/ipk/
				orig_pkg=`ipkg-list-fields $pkgnames | grep OE: | cut -d ' ' -f2`
				pkg_subdir=$arch${TARGET_VENDOR}${@['-' + bb.data.getVar('TARGET_OS', d, 1), ''][bb.data.getVar('TARGET_OS', d, 1) == ('' or 'custom')]}
				mkdir -p ${SDK_OUTPUT}/${prefix}/pkgdata/$pkg_subdir/runtime
				cp ${STAGING_DIR}/pkgdata/$pkg_subdir/$orig_pkg ${SDK_OUTPUT}/${prefix}/pkgdata/$pkg_subdir/
				subpkgs=`cat ${STAGING_DIR}/pkgdata/$pkg_subdir/$orig_pkg | grep PACKAGES: | cut -b 10-`
				for subpkg in $subpkgs; do
					cp ${STAGING_DIR}/pkgdata/$pkg_subdir/runtime/$subpkg ${SDK_OUTPUT}/${prefix}/pkgdata/$pkg_subdir/runtime/
					if [ -e ${STAGING_DIR}/pkgdata/$pkg_subdir/runtime/$subpkg.packaged ];then
						cp ${STAGING_DIR}/pkgdata/$pkg_subdir/runtime/$subpkg.packaged ${SDK_OUTPUT}/${prefix}/pkgdata/$pkg_subdir/runtime/
					fi
					if [ -e ${STAGING_DIR_TARGET}/shlibs/$subpkg.list ]; then
						cp ${STAGING_DIR_TARGET}/shlibs/$subpkg.* ${SDK_OUTPUT}/${prefix}/${TARGET_SYS}/shlibs/
					fi
				done
				break
			fi
		done
	done

	# add missing link to libgcc_s.so.1
	# libgcc-dev should be responsible for that, but it's not getting built
	# RP: it gets smashed up depending on the order that gcc, gcc-cross and 
	# gcc-cross-sdk get built :( (30/11/07)
	ln -sf libgcc_s.so.1 ${SDK_OUTPUT}/${prefix}/${TARGET_SYS}/lib/libgcc_s.so

	# remove unwanted executables
	rm -rf ${SDK_OUTPUT}/${prefix}/sbin ${SDK_OUTPUT}/${prefix}/etc

	# remove broken .la files
	rm -f ${SDK_OUTPUT}/${prefix}/${TARGET_SYS}/lib/*.la

	# fix pkgconfig data files
	if [ -e ${SDK_OUTPUT}/${prefix}/${TARGET_SYS}/lib/pkgconfig ]; then
		cd ${SDK_OUTPUT}/${prefix}/${TARGET_SYS}/lib/pkgconfig
		for f in *.pc ; do
			sed -i 's%=/usr%=${prefix}/${TARGET_SYS}%g' "$f"
		done
		for f in *.pc ; do
			sed -i 's%${STAGING_DIR}%${prefix}%g' "$f"
		done
	fi
	
	# package it up
	mkdir -p ${SDK_DEPLOY}
	cd ${SDK_OUTPUT}
	fakeroot tar cfj ${SDK_DEPLOY}/${DISTRO}-${DISTRO_VERSION}-${FEED_ARCH}-${TARGET_OS}-toolchain.tar.bz2 .
}

do_populate_sdk[nostamp] = "1"
do_populate_sdk[recrdeptask] = "do_package_write"
addtask populate_sdk before do_build after do_install
