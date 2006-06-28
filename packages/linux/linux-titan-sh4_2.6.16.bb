SECTION = "kernel"
DESCRIPTION = "Linux kernel for SH4 based TITAN router appliance"
LICENSE = "GPL"
MAINTAINER = "Jamie Lenehan <lenehan@twibble.org>
PR = "r0"

# The "date=20060328" should be changed to "tag=linux-2_6_16" - but the
# tag won't exit till 2.6.17 is released
SRC_URI = "ftp://ftp.kernel.org/pub/linux/kernel/v2.6/linux-${PV}.tar.bz2 \
cvs://anonymous@linuxsh.cvs.sourceforge.net/cvsroot/linuxsh;module=linux;data=20060331 \
	   file://titan-flash.patch;patch=1 \
	   file://titan-config"
S = "${WORKDIR}/linux-${PV}"

COMPATIBLE_HOST = 'sh4.*-linux'

inherit kernel

ARCH = "sh"
KERNEL_IMAGETYPE = "vmlinux"
KERNEL_OUTPUT = "${KERNEL_IMAGETYPE}"

#
# The linux-sh cvs tree is a "drop in source tree" and needs to be copied
# over the top of the normal linux source since it only includes modified
# files.
#
do_unpack_extra(){
	cp -pPR ${WORKDIR}/linux/* ${S}
}
addtask unpack_extra after do_unpack before do_patch

#
# Use an updated defconfig which includes the flash driver
# The flash driver quality doesn't allow it to be a part of the main kernel
#
do_configure_prepend() {
	install -m 0644 ${WORKDIR}/titan-config ${S}/arch/sh/configs/titan_defconfig
	yes '' | oe_runmake titan_defconfig
}

#
# Should I make the nfs boot image?
#
#do_deploy_titan() {
#	To NFS boot you need to objcopy the image...
#	${HOST_PREFIX}objcopy -O binary -R .note -R .comment -S arch/sh/boot/compressed/vmlinux ${DEPLOY_DIR}/linux.bin
#}
#addtask deploy before do_build after do_compile
