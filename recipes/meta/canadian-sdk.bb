DESCRIPTION = "Meta package for building a installable toolchain"
LICENSE = "MIT"
DEPENDS = "opkg-native opkg-utils-native fakeroot-native sed-native zip-native"
PR = "r5"

# NOTE: We need to save and restore PACKAGE_ARCHS, because sdk.bbclass
# will change HOST_ARCH, which can result in SITEINFO_ENDIANNESS (which
# is computed in siteinfo.bbclass) in changing if the original HOST_ARCH
# endianess differs from the new HOST_ARCH endianess.  SITEINFO_ENDIANNESS
# is used in a number of places, including the construction of the
# PACKAGE_EXTRA_ARCHS list for machines that are capable of running in
# either endianess.  There may be better ways to fix this.

# Save value of PACKAGE_ARCHS (note the ":=" syntax to force immediate eval)
REAL_PACKAGE_ARCHS := "${PACKAGE_ARCHS}"

inherit canadian-sdk meta

# Restore PACKAGE_ARCHS (sdk.bbclass may have caused it to change)
PACKAGE_ARCHS := "${REAL_PACKAGE_ARCHS}"

SDK_DIR = "${WORKDIR}/sdk"
SDK_OUTPUT = "${SDK_DIR}/image"
SDK_DEPLOY = "${DEPLOY_DIR}/sdk"

IPKG_HOST = "opkg-cl -f ${IPKGCONF_CANSDK} -o ${SDK_OUTPUT}"
IPKG_TARGET = "opkg-cl -f ${IPKGCONF_TARGET} -o ${SDK_OUTPUT}/${SDK_PATH}/${TARGET_SYS}"

TOOLCHAIN_CANADIAN_HOST_TASK ?= "task-sdk-canadian-host"
TOOLCHAIN_TARGET_TASK ?= "task-sdk-bare"
FEED_ARCH ?= "${TARGET_ARCH}"
SDK_SUFFIX = "toolchain"
TOOLCHAIN_OUTPUTNAME ?= "${SDK_SYS}-${DISTRO}-${DISTRO_VERSION}-${FEED_ARCH}-${TARGET_OS}-${SDK_SUFFIX}"

RDEPENDS_${PN} = "${TOOLCHAIN_TARGET_TASK} ${TOOLCHAIN_CANADIAN_HOST_TASK}"

TOOLCHAIN_FEED_URI ?= "${DISTRO_FEED_URI}"

modify_opkg_conf () {
        OUTPUT_OPKGCONF_TARGET="${SDK_OUTPUT}/${prefix}/${TARGET_SYS}/${layout_sysconfdir}/opkg.conf"
        OUTPUT_OPKGCONF_HOST="${SDK_OUTPUT}/${prefix}/${TARGET_SYS}/${layout_sysconfdir}/opkg-canadian-sdk.conf"
        OUTPUT_OPKGCONF_SDK="${SDK_OUTPUT}/${sysconfdir}/opkg-canadian-sdk.conf"
        rm ${OUTPUT_OPKGCONF_TARGET}
        rm ${OUTPUT_OPKGCONF_HOST}
        rm ${OUTPUT_OPKGCONF_SDK}
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

	package_generate_ipkg_conf

	for arch in ${PACKAGE_ARCHS}; do
		revipkgarchs="$arch $revipkgarchs"
	done

	mkdir -p ${SDK_OUTPUT}/usr/lib/opkg
	${IPKG_HOST} update
	${IPKG_HOST} -force-depends install ${TOOLCHAIN_CANADIAN_HOST_TASK}

	mkdir -p ${SDK_OUTPUT}/${SDK_PATH}/${TARGET_SYS}/usr/lib/opkg
	${IPKG_TARGET} update
	${IPKG_TARGET} install ${TOOLCHAIN_TARGET_TASK}

	install -d ${SDK_OUTPUT}/${prefix}/usr/lib/opkg
	mv ${SDK_OUTPUT}/usr/lib/opkg/* ${SDK_OUTPUT}/${prefix}/usr/lib/opkg/
	rm -Rf ${SDK_OUTPUT}/usr/lib

	install -d ${SDK_OUTPUT}/${prefix}/${TARGET_SYS}/${layout_sysconfdir}
	install -m 0644 ${IPKGCONF_TARGET} ${IPKGCONF_CANSDK} ${SDK_OUTPUT}/${prefix}/${TARGET_SYS}/${layout_sysconfdir}/

	install -d ${SDK_OUTPUT}/${sysconfdir}
	install -m 0644 ${IPKGCONF_CANSDK} ${SDK_OUTPUT}/${sysconfdir}/

	# extract and store ipks, pkgdata and shlibs data
	target_pkgs=`cat ${SDK_OUTPUT}/${prefix}/package-status | grep Package: | cut -f 2 -d ' '`
	mkdir -p ${SDK_OUTPUT}/${prefix}/ipk/
	mkdir -p ${SDK_OUTPUT}/${prefix}/pkgdata/runtime/
	mkdir -p ${SDK_OUTPUT}/${prefix}/${TARGET_SYS}/shlibs/
	for pkg in $target_pkgs ; do
		for arch in $revipkgarchs; do
			pkgnames=${DEPLOY_DIR_IPK}/$arch/${pkg}_*_$arch.ipk
			if [ -e $pkgnames ]; then
				oenote "Found $pkgnames"
				cp $pkgnames ${SDK_OUTPUT}/${prefix}/ipk/
				orig_pkg=`opkg-list-fields $pkgnames | grep OE: | cut -d ' ' -f2`
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

	# With sysroot support, gcc expects the default C++ headers to be
	# in a specific place.
	install -d ${SDK_OUTPUT}/${prefix}/${TARGET_SYS}/include
	mv ${SDK_OUTPUT}/${prefix}/${TARGET_SYS}/usr/include/c++ \
		${SDK_OUTPUT}/${prefix}/${TARGET_SYS}/include/

	# Fix or remove broken .la files
	for i in `find ${SDK_OUTPUT}/${prefix}/${TARGET_SYS} -name \*.la`; do
		sed -i 	-e "/^dependency_libs=/s,\([[:space:]']\)${layout_base_libdir},\1${prefix}/${TARGET_SYS}${layout_base_libdir},g" \
			-e "/^dependency_libs=/s,\([[:space:]']\)${layout_libdir},\1${prefix}/${TARGET_SYS}${layout_libdir},g" \
			-e "/^dependency_libs=/s,\-\([LR]\)${layout_base_libdir},-\1${prefix}/${TARGET_SYS}${layout_base_libdir},g" \
			-e "/^dependency_libs=/s,\-\([LR]\)${layout_libdir},-\1${prefix}/${TARGET_SYS}${layout_libdir},g" \
			-e 's/^installed=yes$/installed=no/' $i
	done
	rm -f ${SDK_OUTPUT}/${prefix}/lib/*.la

	# Setup site file for external use
	siteconfig=${SDK_OUTPUT}/${prefix}/site-config
	touch $siteconfig
	for sitefile in ${CONFIG_SITE} ; do
		cat $sitefile >> $siteconfig
	done

	# Create environment setup script
	script=${SDK_OUTPUT}/${prefix}/environment-setup
	touch $script
	echo 'export PATH=${prefix}/bin:$PATH' >> $script
	echo 'export LIBTOOL_SYSROOT_PATH=${prefix}/${TARGET_SYS}' >> $script
	echo 'export PKG_CONFIG_SYSROOT_DIR=${prefix}/${TARGET_SYS}' >> $script
	echo 'export PKG_CONFIG_PATH=${prefix}/${TARGET_SYS}${layout_libdir}/pkgconfig' >> $script
	echo 'export CONFIG_SITE=${prefix}/site-config' >> $script
	echo "alias opkg='LD_LIBRARY_PATH=${prefix}/lib ${prefix}/bin/opkg-cl -f ${sysconfdir}/opkg-canadian-sdk.conf -o ${prefix}'" >> $script
	echo "alias opkg-target='LD_LIBRARY_PATH=${prefix}/lib ${prefix}/bin/opkg-cl -f ${prefix}/${TARGET_SYS}${layout_sysconfdir}/opkg.conf -o ${prefix}/${TARGET_SYS}'" >> $script

	# Add version information
	versionfile=${SDK_OUTPUT}/${prefix}/version
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
	rm -f ${SDK_DEPLOY}/${TOOLCHAIN_OUTPUTNAME}.zip
	zip -r -D ${SDK_DEPLOY}/${TOOLCHAIN_OUTPUTNAME}.zip .
}

do_populate_sdk[nostamp] = "1"
do_populate_sdk[lockfiles] = "${DEPLOY_DIR_IPK}.lock"
addtask package_update_index_ipk before do_populate_sdk
addtask populate_sdk before do_build after do_install
