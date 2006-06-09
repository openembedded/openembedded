SECTION = "kernel"
DESCRIPTION = "Linux kernel for Hitachi SH3 based Jornada 6xx"
LICENSE = "GPL"
PR = "r0"

COMPATIBLE_HOST = "sh.*-linux"
COMPATIBLE_MACHINE = 'jornada6xx'

SRC_URI = "http://www.jlime.com/downloads/Releases/donkey/kernels/6xx/sources/jlime-2.6.16.20-patched.tar.gz \
           file://defconfig_jlime \
	   file://volatile-traps.c.patch;patch=1  \
	   file://volatile-signal.c.patch;patch=1 \
	   file://volatile-sys_sh.c.patch;patch=1 \
	   file://volatile-setup.c.patch;patch=1 \
	   file://Optimize-O1.patch;patch=1"

S = "${WORKDIR}/linux-${PV}"

inherit kernel

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
