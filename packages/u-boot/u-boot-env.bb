DESCRIPTION = "Dummy package to get uboot env image into deploy"

PR = "r1"

inherit kernel-arch

SRC_URI = "file://default-env.ascr"


do_compile() {
	cp ${WORKDIR}/default-env.ascr ${S}	
	uboot-mkimage -A ${UBOOT_ARCH} -O linux -T script -C none -a 0 -e 0 -n "${DISTRO_NAME}/${MACHINE} env script" -d default-env.ascr default_env.img 
}

do_stage() {
	install -d ${DEPLOY_DIR_IMAGE}
	install -m 0644 ${S}/default_env.img ${DEPLOY_DIR_IMAGE}/
	package_stagefile_shell ${DEPLOY_DIR_IMAGE}/default_env.img

}


PACKAGE_ARCH = "${MACHINE_ARCH}"
