DESCRIPTION = "Installkit for kexecboot-kernel"
DEPENDS = "zaurus-updater linux-kexecboot"
PR = "r0"

PACKAGES = ""
PACKAGE_ARCH = "${MACHINE_ARCH}"
COMPATIBLE_MACHINE = '(poodle|c7x0|spitz|akita|tosa)'

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

	cp updater.sh.${MACHINE} installkit-${MACHINE}/updater.sh
 
	tar czf ${DEPLOY_DIR_IMAGE}/installkit-${MACHINE}.tar.gz installkit-${MACHINE}/
	md5sum ${DEPLOY_DIR_IMAGE}/installkit-${MACHINE}.tar.gz > ${DEPLOY_DIR_IMAGE}/installkit-${MACHINE}.tar.gz.md5
	rm -rf ${DEPLOY_DIR_IMAGE}/installkit-${MACHINE}/     
}

addtask deploy before do_build after do_compile
