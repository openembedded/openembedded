DESCRIPTION = "Installkit for kexecboot-kernel"
DEPENDS = "${@base_conditional('MACHINE', 'collie', 'linux-kexecboot', 'zaurus-updater linux-kexecboot', d)}"
LICENSE = "zaurus-installer"
PR = "r1"

PACKAGES = ""
PACKAGE_ARCH = "${MACHINE_ARCH}"
COMPATIBLE_MACHINE = '(collie|poodle|c7x0|spitz|akita|tosa)'

S = "${WORKDIR}"

do_configure() {
}

do_compile() {
}

do_deploy() {

	cd ${DEPLOY_DIR_IMAGE}
	rm -rf ${DEPLOY_DIR_IMAGE}/installkit-${MACHINE}/
	mkdir installkit-${MACHINE}/

	[ -f "${KERNEL_IMAGETYPE}-kexecboot-${MACHINE}.bin" ] && cp ${KERNEL_IMAGETYPE}-kexecboot-${MACHINE}.bin installkit-${MACHINE}/${KERNEL_IMAGETYPE}

	if [ ! "${MACHINE}" = "collie" ]; then
		cp updater.sh.${MACHINE} installkit-${MACHINE}/updater.sh
	fi
 
	tar czf ${DEPLOY_DIR_IMAGE}/installkit-${MACHINE}.tar.gz installkit-${MACHINE}/
	md5sum ${DEPLOY_DIR_IMAGE}/installkit-${MACHINE}.tar.gz > ${DEPLOY_DIR_IMAGE}/installkit-${MACHINE}.tar.gz.md5
	rm -rf ${DEPLOY_DIR_IMAGE}/installkit-${MACHINE}/
}

addtask deploy before do_build after do_compile
