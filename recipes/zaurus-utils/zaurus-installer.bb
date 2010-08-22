DESCRIPTION = "Installkit for kexecboot-kernel"
DEPENDS = "${@base_conditional('MACHINE', 'collie', 'linux-kexecboot', 'zaurus-updater linux-kexecboot', d)}"
DEPENDS += "${@base_conditional('MACHINE', 'spitz', 'zaurus-legacy-tar', '', d)}"
LICENSE = "zaurus-installer"
PR = "r4"

PACKAGES = ""
PACKAGE_ARCH = "${MACHINE_ARCH}"
COMPATIBLE_MACHINE = '(collie|poodle|c7x0|spitz|akita|tosa)'

do_compile() {
}

do_deploy() {

        cd ${DEPLOY_DIR_IMAGE}
        rm -rf ${DEPLOY_DIR_IMAGE}/installkit-${MACHINE}/
        mkdir installkit-${MACHINE}/

        [ -f "${KERNEL_IMAGETYPE}-kexecboot-${MACHINE}.bin" ] && cp ${KERNEL_IMAGETYPE}-kexecboot-${MACHINE}.bin installkit-${MACHINE}/${KERNEL_IMAGETYPE}

        if [ ! "${MACHINE}" = "collie" ]; then
                cp updater.sh installkit-${MACHINE}/updater.sh
        fi

        if [ "${MACHINE}" = "spitz" ]; then
                cp ${DEPLOY_DIR_IMAGE}/gnu-tar installkit-${MACHINE}/gnu-tar
        fi

        tar czf ${DEPLOY_DIR_IMAGE}/installkit-${MACHINE}.tar.gz installkit-${MACHINE}/
        md5sum ${DEPLOY_DIR_IMAGE}/installkit-${MACHINE}.tar.gz > ${DEPLOY_DIR_IMAGE}/installkit-${MACHINE}.tar.gz.md5
        rm -rf ${DEPLOY_DIR_IMAGE}/installkit-${MACHINE}/

        package_stagefile_shell ${DEPLOY_DIR_IMAGE}/installkit-${MACHINE}.tar.gz
        package_stagefile_shell ${DEPLOY_DIR_IMAGE}/installkit-${MACHINE}.tar.gz.md5
}

# package_stagefile_shell need to run before populate_sysroot for packaged-staging
addtask deploy before do_populate_sysroot after do_compile
