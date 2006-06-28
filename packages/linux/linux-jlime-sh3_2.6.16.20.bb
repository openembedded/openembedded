SECTION = "kernel"
DESCRIPTION = "Linux kernel for Hitachi SH3 based Jornada 6xx"
LICENSE = "GPL"
PR = "r0"

COMPATIBLE_HOST = "sh.*-linux"
COMPATIBLE_MACHINE = 'jornada6xx'

SRC_URI = "http://www.jlime.com/downloads/Releases/donkey/kernels/6xx/sources/jlime-2.6.16.20-patched.tar.gz \
           file://defconfig_jlime"
	   	            
S = "${WORKDIR}/linux-${PV}"

inherit kernel

#Lets let 3.4.x handle the compilation of this one
KERNEL_CCSUFFIX = "-3.4.3"

ARCH = "sh"
KERNEL_IMAGETYPE = "zImage"
FILES_kernel-image = "/boot/${KERNEL_IMAGETYPE}*"

do_configure_prepend() {
	install -m 0644 ${WORKDIR}/defconfig_jlime ${S}/.config
}

do_deploy() {
        install -d ${DEPLOY_DIR_IMAGE}
	install -m 0644 arch/$(ARCH)/boot/$(KERNEL_IMAGETYPE) $(DEPLOY_DIR)/images/$(KERNEL_IMAGETYPE)
}
