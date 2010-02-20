DESCRIPTION = "This package allows OE to work with an external toolchain generated \
               by meta-toolchain instead of building its own. It expects that toolchain \
               to be located in SDK_PATH/prefix."

PROVIDES = "\
    linux-libc-headers \
    virtual/${TARGET_PREFIX}gcc \
    virtual/${TARGET_PREFIX}gcc-initial \
    virtual/${TARGET_PREFIX}gcc-intermediate \
    virtual/${TARGET_PREFIX}binutils \
    virtual/${TARGET_PREFIX}libc-for-gcc \
    virtual/libc \
    virtual/libintl \
    virtual/libiconv \
    "

RPROVIDES = "glibc-utils libsegfault glibc-thread-db libgcc-dev libgcc libstdc++-dev libstdc++"
PACKAGES_DYNAMIC = "glibc-gconv-*"
PR = "r2"

inherit sdk

do_stage() {
	if [ ! -e ${prefix}/package-status -a ! -e ${prefix}/usr/lib/opkg/status ]; then
		echo "The package status file of the external toolchain could not be found in ${prefix}!"
		exit 1
	fi
	
	install -d ${STAGING_DIR}/pkgdata/
	install -d ${STAGING_DIR_TARGET}/shlibs/

	cp -pPRr ${prefix}/pkgdata/* ${STAGING_DIR}/pkgdata/
	cp -pPRr ${prefix}/${TARGET_SYS}/shlibs/* ${STAGING_DIR_TARGET}/shlibs/

	if [ -d ${prefix}/ipk ]; then
		install -d ${DEPLOY_DIR_IPK}/
		cp -pPRr ${prefix}/ipk/* ${DEPLOY_DIR_IPK}/
	fi

	if [ -d ${prefix}/deb ]; then
		install -d ${DEPLOY_DIR_DEB}/
		cp -pPRr ${prefix}/deb/* ${DEPLOY_DIR_DEB}/
	fi

	if [ -d ${prefix}/pstage -a "x${DEPLOY_DIR_PSTAGE}" != "x" ]; then
		install -d ${DEPLOY_DIR_PSTAGE}/
		cp -pPRr ${prefix}/pstage/* ${DEPLOY_DIR_PSTAGE}/
	fi
}
