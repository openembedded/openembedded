# SDK packages are built either explicitly by the user,
# or indirectly via dependency.  No need to be in 'world'.
EXCLUDE_FROM_WORLD = "1"

SDK_NAME = "${DISTRO}/${TARGET_ARCH}"

OLD_PACKAGE_ARCH := ${PACKAGE_ARCH}
PACKAGE_ARCH = "${BUILD_ARCH}-${OLD_PACKAGE_ARCH}-sdk"

HOST_ARCH = "${BUILD_ARCH}"
HOST_VENDOR = "${BUILD_VENDOR}"
HOST_OS = "${BUILD_OS}"
HOST_PREFIX = "${BUILD_PREFIX}"
HOST_CC_ARCH = "${BUILD_CC_ARCH}"

CPPFLAGS = "${BUILD_CPPFLAGS}"
CFLAGS = "${BUILD_CFLAGS}"
CXXFLAGS = "${BUILD_CFLAGS}"
LDFLAGS = "${BUILD_LDFLAGS}"

prefix = "/usr/local/${SDK_NAME}"
exec_prefix = "${prefix}"
base_prefix = "${exec_prefix}"

FILES_${PN} = "${prefix}"
FILES_${PN}-dbg += "${prefix}/bin/.debug \
                    ${prefix}/sbin/.debug \
                   "

sdk_ipk_do_indexes () {
	set -x

	ipkgarchs="${PACKAGE_ARCHS}"

        if [ -z "${DEPLOY_KEEP_PACKAGES}" ]; then
                touch ${DEPLOY_DIR_IPK}/Packages
                ipkg-make-index -r ${DEPLOY_DIR_IPK}/Packages -p ${DEPLOY_DIR_IPK}/Packages -l ${DEPLOY_DIR_IPK}/Packages.filelist -m ${DEPLOY_DIR_IPK}
        fi

	for arch in $ipkgarchs; do
		if [ -z "${DEPLOY_KEEP_PACKAGES}" ]; then
			if [ -e ${DEPLOY_DIR_IPK}/${BUILD_ARCH}-$arch-sdk/ ] ; then 
				touch ${DEPLOY_DIR_IPK}/${BUILD_ARCH}-$arch-sdk/Packages
				ipkg-make-index -r ${DEPLOY_DIR_IPK}/${BUILD_ARCH}-$arch-sdk/Packages -p ${DEPLOY_DIR_IPK}/${BUILD_ARCH}-$arch-sdk/Packages -l ${DEPLOY_DIR_IPK}/${BUILD_ARCH}-$arch-sdk/Packages.filelist -m ${DEPLOY_DIR_IPK}/${BUILD_ARCH}-$arch-sdk/
			fi
		fi
	done
}
