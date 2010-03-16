SECTION = "kernel"
DESCRIPTION = "Linux kernel for the Linksys WRT54 devices"
LICENSE = "GPLv2"
PR = "r1"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.4/linux-2.4.20.tar.bz2 \
	   file://linux-2.4.20-mipscvs.patch;patch=1 \
	   file://2.4.20_broadcom_3_37_2_1109_US.patch;patch=1 \
	   file://110-sch_htb.patch;patch=1 \
	   file://120-openwrt.patch;patch=1 \
	   file://130-nfsswap.patch;patch=1 \
	   file://140-ebtables-brnf-5.patch;patch=1 \
	   file://150-mppe-mppc-0.98.patch;patch=1 \
	   file://160-expr.patch;patch=1 \
	   file://linux-2.4.24-attribute-used.patch;patch=1 \
	   file://gcc_mtune.patch;patch=1 \
	   file://gcc3.patch;patch=1 \
	   file://nobcom.patch;patch=1 \
	   file://compressed-20040531.tar.bz2 \
	   file://diag.c \
           file://defconfig"
S = "${WORKDIR}/linux-2.4.20"


COMPATIBLE_HOST = 'mipsel.*-linux'

inherit kernel

CMDLINE_CONSOLE ?= "ttyS0,115200n8"
CMDLINE_ROOT ?= "root=/dev/mtdblock2 noinitrd"
# CMDLINE_INIT = "init=/bin/busybox ash"
CMDLINE_INIT ?= " "
CMDLINE = "${CMDLINE_ROOT} ${CMDLINE_CONSOLE} ${CMDLINE_INIT}"
EXTRA_OEMAKE += "'SRCBASE=${STAGING_LIBDIR}/bcom'"

do_unpack_extra(){
	install -m 0644 ${WORKDIR}/diag.c ${S}/drivers/net/diag/diag_led.c
	if [ -e ${WORKDIR}/compressed ]; then
		rm -rf ${S}/arch/mips/brcm-boards/bcm947xx/compressed
		mv ${WORKDIR}/compressed ${S}/arch/mips/brcm-boards/bcm947xx/compressed
	fi
}
addtask unpack_extra after do_patch before do_configure

do_configure_prepend() {
	install -m 0644 ${WORKDIR}/defconfig ${S}/.config
	echo "CONFIG_CMDLINE=\"${CMDLINE}\"" >> ${S}/.config
}

COMPATIBLE_MACHINE = "wrt54"
