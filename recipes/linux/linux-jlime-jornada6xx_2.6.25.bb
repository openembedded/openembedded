SECTION = "kernel"
DESCRIPTION = "JLime Linux kernel for SuperH based Jornada 6xx"
LICENSE = "GPLv2"
PR = "r0"

SRCREV = "${AUTOREV}"

COMPATIBLE_HOST = "sh.*-linux"
#COMPATIBLE_MACHINE = "jornada6xx"

SRC_URI = "git://jlime.org/jlime-stable.git;protocol=git;branch=v2.6.25-stable"

S = "${WORKDIR}/git"

inherit kernel

#Lets let 3.4.x handle the compilation of this one
KERNEL_CCSUFFIX = "-3.4.4"

ARCH = "sh"
FILES_kernel-image = "/boot/${KERNEL_IMAGETYPE}*"

do_configure_prepend() {
	install -m 0644 ${S}/config-hp6xx-2.6.25 ${S}/.config
}

do_deploy() {
        install -d ${DEPLOY_DIR_IMAGE}
	install -m 0644 arch/${ARCH}/boot/${KERNEL_IMAGETYPE} ${DEPLOY_DIR}/images/${KERNEL_IMAGETYPE}
}
