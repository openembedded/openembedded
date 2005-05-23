SECTION = "kernel"
DESCRIPTION = "Linux kernel for Hitachi SH3 based Jornada 6xx"
LICENSE = "GPL"
PR = "r0"

SRC_URI = "http://www.jlime.com/downloads/releases/shrek/kernels/6xx/sources/linuxsh-snapshot-050320-jlimepatched-3.tar.bz2 \
           file://defconfig_jlime"

S = "${WORKDIR}/linux-${PV}"

inherit kernel

ARCH = "sh"
KERNEL_IMAGETYPE = "zImage"
FILES_kernel-image = "/boot/${KERNEL_IMAGETYPE}*"

do_configure_prepend() {
	install -m 0644 ${WORKDIR}/defconfig_jlime ${S}/.config
}

do_deploy() {
        install -d ${DEPLOY_DIR}/images
	install -m 0644 arch/$(ARCH)/boot/$(KERNEL_IMAGETYPE) $(DEPLOY_DIR)/images/$(KERNEL_IMAGETYPE)
}
