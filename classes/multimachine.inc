STAMP = "${TMPDIR}/stamps/${PACKAGE_ARCH}-${HOST_OS}/${PF}"
WORKDIR = "${TMPDIR}/work/${PACKAGE_ARCH}-${HOST_OS}/${PF}"
STAGING_KERNEL_DIR = "${STAGING_DIR}/${PACKAGE_ARCH}-${HOST_OS}/kernel"

#DEPLOY_DIR_SUFFIX = "${@['', bb.data.getVar('PACKAGE_ARCH', d, 1)][bb.data.getVar('PACKAGE_ARCH', d, 1) != bb.data.getVar('HOST_ARCH', d, 1)]}"
