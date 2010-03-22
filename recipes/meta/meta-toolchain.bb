DESCRIPTION = "Meta package for building a installable toolchain"
LICENSE = "MIT"
DEPENDS = "opkg-native ipkg-utils-native fakeroot-native sed-native"

inherit meta

SDK_DIR = "${WORKDIR}/sdk"
SDK_OUTPUT = "${SDK_DIR}/image"
SDK_OUTPUT2 = "${SDK_DIR}/image-extras"
SDK_DEPLOY = "${DEPLOY_DIR}/sdk"

IPKG_HOST = "opkg-cl -f ${IPKGCONF_SDK} -o ${SDK_OUTPUT}"
IPKG_TARGET = "opkg-cl -f ${IPKGCONF_TARGET} -o ${SDK_OUTPUT}/${SDKPATH}/${TARGET_SYS}"

TOOLCHAIN_HOST_TASK ?= "task-sdk-host"
TOOLCHAIN_TARGET_TASK ?= "task-sdk-bare"
TOOLCHAIN_TARGET_EXCLUDE ?= ""
FEED_ARCH ?= "${TARGET_ARCH}"
SDK_SUFFIX = "toolchain"
TOOLCHAIN_OUTPUTNAME ?= "${DISTRO}-${DISTRO_VERSION}-${SDK_SYS}-${FEED_ARCH}-${TARGET_OS}-${SDK_SUFFIX}"

RDEPENDS = "${TOOLCHAIN_TARGET_TASK} ${TOOLCHAIN_HOST_TASK}"

TOOLCHAIN_FEED_URI ?= "${DISTRO_FEED_URI}"

modify_opkg_conf () {
        OUTPUT_OPKGCONF_TARGET="${SDK_OUTPUT}/${SDKPATH}/${TARGET_SYS}/${sysconfdir}/opkg.conf"
        OUTPUT_OPKGCONF_HOST="${SDK_OUTPUT}/${SDKPATH}/${TARGET_SYS}/${sysconfdir}/opkg-sdk.conf"
        OUTPUT_OPKGCONF_SDK="${SDK_OUTPUT}/${sysconfdir}/opkg-sdk.conf"
        rm -f ${OUTPUT_OPKGCONF_TARGET}
        rm -f ${OUTPUT_OPKGCONF_HOST}
        rm -f ${OUTPUT_OPKGCONF_SDK}
        opkgarchs="${PACKAGE_ARCHS}"
        priority=1
        for arch in ${opkgarchs}; do
                echo "arch ${arch} ${priority}" >> ${OUTPUT_OPKGCONF_TARGET};
                echo "src/gz ${arch} ${TOOLCHAIN_FEED_URI}/${arch}" >> ${OUTPUT_OPKGCONF_TARGET};
                priority=$(expr ${priority} + 5);
        done
}

do_populate_sdk() {
	rm -rf ${SDK_OUTPUT}
	mkdir -p ${SDK_OUTPUT}
	mkdir -p ${SDK_OUTPUT}${libdir}/opkg/
	mkdir -p ${SDK_OUTPUT}/${SDKPATH}/${TARGET_SYS}${libdir}/opkg/

	package_generate_ipkg_conf

	for arch in ${PACKAGE_ARCHS}; do
		revipkgarchs="$arch $revipkgarchs"
	done

	${IPKG_HOST} update
	${IPKG_HOST} -force-depends install ${TOOLCHAIN_HOST_TASK}

	${IPKG_TARGET} update
	${IPKG_TARGET} install ${TOOLCHAIN_TARGET_TASK}

	# Remove packages in the exclude list which were installed by dependencies
	if [ ! -z "${TOOLCHAIN_TARGET_EXCLUDE}" ]; then
		${IPKG_TARGET} remove -force-depends ${TOOLCHAIN_TARGET_EXCLUDE}
	fi

	install -d ${SDK_OUTPUT}/${SDKPATH}/usr/lib/opkg
	mv ${SDK_OUTPUT}/usr/lib/opkg/* ${SDK_OUTPUT}/${SDKPATH}/usr/lib/opkg/
	rm -Rf ${SDK_OUTPUT}/usr/lib

	# Clean up empty directories from excluded packages
	find ${SDK_OUTPUT} -depth -type d -empty -print0 | xargs -r0 /bin/rmdir

	install -d ${SDK_OUTPUT}/${SDKPATH}/${TARGET_SYS}/${sysconfdir}
	install -m 0644 ${IPKGCONF_TARGET} ${IPKGCONF_SDK} ${SDK_OUTPUT}/${SDKPATH}/${TARGET_SYS}/${sysconfdir}/

	install -d ${SDK_OUTPUT}/${SDKPATH}/${sysconfdir}
	install -m 0644 ${IPKGCONF_SDK} ${SDK_OUTPUT}/${SDKPATH}/${sysconfdir}/

	# extract and store ipks, pkgdata and shlibs data
	target_pkgs=`cat ${SDK_OUTPUT}/${SDKPATH}/${TARGET_SYS}/usr/lib/opkg/status | grep Package: | cut -f 2 -d ' '`
	mkdir -p ${SDK_OUTPUT2}/${SDKPATH}/ipk/
	mkdir -p ${SDK_OUTPUT2}/${SDKPATH}/pkgdata/runtime/
	mkdir -p ${SDK_OUTPUT2}/${SDKPATH}/${TARGET_SYS}/shlibs/
	for pkg in $target_pkgs ; do
		for arch in $revipkgarchs; do
			pkgnames=${DEPLOY_DIR_IPK}/$arch/${pkg}_*_$arch.ipk
			if [ -e $pkgnames ]; then
				oenote "Found $pkgnames"
				cp $pkgnames ${SDK_OUTPUT2}/${SDKPATH}/ipk/
				orig_pkg=`ipkg-list-fields $pkgnames | grep OE: | cut -d ' ' -f2`
				pkg_subdir=$arch${TARGET_VENDOR}${@['-' + bb.data.getVar('TARGET_OS', d, 1), ''][bb.data.getVar('TARGET_OS', d, 1) == ('' or 'custom')]}
				mkdir -p ${SDK_OUTPUT2}/${SDKPATH}/pkgdata/$pkg_subdir/runtime
				cp ${TMPDIR}/pkgdata/$pkg_subdir/$orig_pkg ${SDK_OUTPUT2}/${SDKPATH}/pkgdata/$pkg_subdir/
				subpkgs=`cat ${TMPDIR}/pkgdata/$pkg_subdir/$orig_pkg | grep PACKAGES: | cut -b 10-`
				for subpkg in $subpkgs; do
					cp ${TMPDIR}/pkgdata/$pkg_subdir/runtime/$subpkg ${SDK_OUTPUT2}/${SDKPATH}/pkgdata/$pkg_subdir/runtime/
					if [ -e ${TMPDIR}/pkgdata/$pkg_subdir/runtime/$subpkg.packaged ];then
						cp ${TMPDIR}/pkgdata/$pkg_subdir/runtime/$subpkg.packaged ${SDK_OUTPUT2}/${SDKPATH}/pkgdata/$pkg_subdir/runtime/
					fi
					if [ -e ${STAGING_DIR_TARGET}/shlibs/$subpkg.list ]; then
						cp ${STAGING_DIR_TARGET}/shlibs/$subpkg.* ${SDK_OUTPUT2}/${SDKPATH}/${TARGET_SYS}/shlibs/
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
	ln -sf libgcc_s.so.1 ${SDK_OUTPUT}/${SDKPATH}/${TARGET_SYS}/lib/libgcc_s.so

	# With sysroot support, gcc expects the default C++ headers to be
	# in a specific place.
	install -d ${SDK_OUTPUT}/${SDKPATH}/${TARGET_SYS}/include
	mv ${SDK_OUTPUT}/${SDKPATH}/${TARGET_SYS}/usr/include/c++ \
		${SDK_OUTPUT}/${SDKPATH}/${TARGET_SYS}/include/

	# Fix or remove broken .la files
	for i in `find ${SDK_OUTPUT}/${SDKPATH}/${TARGET_SYS} -name \*.la`; do
		sed -i 	-e "/^dependency_libs=/s,\([[:space:]']\)${base_libdir},\1\$SDK_PATH/\$TARGET_SYS${base_libdir},g" \
			-e "/^dependency_libs=/s,\([[:space:]']\)${libdir},\1\$SDK_PATH/\$TARGET_SYS${libdir},g" \
			-e "/^dependency_libs=/s,\-\([LR]\)${base_libdir},-\1\$SDK_PATH/\$TARGET_SYS${base_libdir},g" \
			-e "/^dependency_libs=/s,\-\([LR]\)${libdir},-\1\$SDK_PATH/\$TARGET_SYS${libdir},g" \
			-e 's/^installed=yes$/installed=no/' $i
	done
	rm -f ${SDK_OUTPUT}/${SDKPATH}/lib/*.la

	# Setup site file for external use
	siteconfig=${SDK_OUTPUT}/${SDKPATH}/site-config
	touch $siteconfig
	for sitefile in ${CONFIG_SITE} ; do
		cat $sitefile >> $siteconfig
	done

	# Create environment setup script
	script=${SDK_OUTPUT}/${SDKPATH}/environment-setup
	touch $script
	echo 'export SDK_PATH=${SDKPATH}' >> $script
	echo 'export TARGET_SYS=${TARGET_SYS}' >> $script
	echo 'export PATH=$SDK_PATH/bin:$PATH' >> $script
	echo 'export CPATH=$SDK_PATH/$TARGET_SYS/usr/include:$CPATH' >> $script
	echo 'export LIBTOOL_SYSROOT_PATH=$SDK_PATH/$TARGET_SYS' >> $script
	echo 'export PKG_CONFIG_SYSROOT_DIR=$SDK_PATH/$TARGET_SYS' >> $script
	echo 'export PKG_CONFIG_PATH=$SDK_PATH/$TARGET_SYS${libdir}/pkgconfig' >> $script
	echo 'export CONFIG_SITE=$SDK_PATH/site-config' >> $script
	echo "alias opkg='LD_LIBRARY_PATH=$SDK_PATH/lib $SDK_PATH/bin/opkg-cl -f $SDK_PATH/${sysconfdir}/opkg-sdk.conf -o $SDK_PATH'" >> $script
	echo "alias opkg-target='LD_LIBRARY_PATH=$SDK_PATH/lib $SDK_PATH/bin/opkg-cl -f $SDK_PATH/$TARGET_SYS${sysconfdir}/opkg.conf -o $SDK_PATH/$TARGET_SYS'" >> $script

	# Add version information
	versionfile=${SDK_OUTPUT}/${SDKPATH}/version
	touch $versionfile
	echo 'Distro: ${DISTRO}' >> $versionfile
	echo 'Distro Version: ${DISTRO_VERSION}' >> $versionfile
	echo 'Metadata Revision: ${METADATA_REVISION}' >> $versionfile
	echo 'Timestamp: ${DATETIME}' >> $versionfile

	modify_opkg_conf

	# Package it up
	mkdir -p ${SDK_DEPLOY}
	cd ${SDK_OUTPUT}
	fakeroot tar cfj ${SDK_DEPLOY}/${TOOLCHAIN_OUTPUTNAME}.tar.bz2 .
	cd ${SDK_OUTPUT2}
	fakeroot tar cfj ${SDK_DEPLOY}/${TOOLCHAIN_OUTPUTNAME}-extras.tar.bz2 .
}

do_populate_sdk[nostamp] = "1"
addtask package_update_index_ipk before do_populate_sdk
addtask populate_sdk before do_build after do_install
