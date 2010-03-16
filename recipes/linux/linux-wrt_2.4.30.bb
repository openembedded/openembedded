SECTION = "kernel"
DESCRIPTION = "Linux kernel for the Linksys WRT54 devices"
HOMEPAGE = "http://openwrt.org"
DEPENDS = "lzma-native"
LICENSE = "GPLv2"
PR = "r2"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.4/linux-2.4.30.tar.bz2 \
	cvs://anonymous@openwrt.org/openwrt;module=openwrt/package/linux/kernel-source;tag=TESTED \
	http://downloads.openwrt.org/sources/kernel-binary-wl-0.2.tar.gz \
	http://downloads.openwrt.org/sources/kernel-source-et-0.6.tar.gz \
	file://000-linux-mips-2_4_30.patch;patch=1 \
	file://001-Makefile;patch=1 \
	file://002-Rules_make;patch=1 \
	file://003-arch_mips_Makefile;patch=1 \
	file://005-arch_mips_config-shared_in;patch=1 \
	file://007-arch_mips_kernel_cpu-probe_c;patch=1 \
	file://009-arch_mips_kernel_head_S;patch=1 \
	file://010-arch_mips_kernel_proc_c;patch=1 \
	file://011-arch_mips_kernel_setup_c;patch=1 \
	file://012-arch_mips_kernel_traps_c;patch=1 \
	file://017-arch_mips_pci_Makefile;patch=1 \
	file://018_drivers_char_mem_c;patch=1 \
	file://019-drivers_char_serial_c;patch=1 \
	file://020-drivers_mtd-jumbo;patch=1 \
	file://021-drivers_net_Config_in-hnd;patch=1 \
	file://022-drivers_net_Makefile;patch=1 \
	file://023-drivers_parport_Makefile;patch=1 \
	file://024-drivers_parport_Config_in;patch=1 \
	file://028-drivers_pcmcia_Makefile;patch=1 \
	file://029-arch_mips_mm_c-r4k_c;patch=1 \
	file://031-include_asm-mips_bootinfo_h;patch=1 \
	file://033-include_asm-mips_cpu_h;patch=1 \
	file://036-include_asm-mips_serial_h;patch=1 \
	file://037-init_do_mounts_c;patch=1 \
	file://100-gcc3-mtune;patch=1 \
	file://200-include_linux_netdevice_h.patch;patch=1 \
	file://201-include_linux_skbuff_h.patch;patch=1 \
	file://202-net_core_Makefile.patch;patch=1 \
	file://203-net_core_dev_c.patch;patch=1 \
	file://204-net_sched_sched_api_c.patch;patch=1 \
	file://205-net_sched_sched_generic_c.patch;patch=1 \
	file://206-include_net_pkt_sched_h.patch;patch=1 \
	file://207-hfsplus-fix;patch=1 \
	file://208-gcc-3.4-fix;patch=1 \
	file://300-squashfs2.1;patch=1 \
	file://301-jffs-compression;patch=1 \
	file://302-ebtables;patch=1 \
	file://303-mppe-mppc;patch=1 \
	file://304-netfilter-ipp2p-0.7.4;patch=1 \
	file://305-cifs-1.20c;patch=1 \
	file://306-netfilter-layer7-0.9.1;patch=1 \
	file://307-gcc-3.4-fix.patch;patch=1 \
	file://308-netfilter-nat-pptp;patch=1 \
	file://309-drivers_net_b44_c.patch;patch=1 \
	file://310-netfilter-maxconn;patch=1 \
	file://311-ipsec-nat-traversal;patch=1 \
	file://312-netfilter-TTL;patch=1 \
	file://313-gcc-4.0-fixes;patch=1 \
	file://314-drivers_net_b44_h.patch;patch=1 \
	file://315-include_linux_pci_ids_h.patch;patch=1 \
	file://316-b44_mii_phy.patch;patch=1 \
	file://400-i4l-cvs-2-4-29;patch=1 \
	file://401-hfc-usb-backport-i4l-cvs;patch=1 \
	file://402-pl2303-backport-2-4-29;patch=1 \
	file://403-netdev_random_core.patch;patch=1 \
	file://404-netdev_random_et.patch;patch=1 \
	file://600-linux-squashfs-lzma;patch=1 \
	file://600-optional-aout-support;patch=1 \
	file://linux.config"

S = "${WORKDIR}/linux-2.4.30"

COMPATIBLE_HOST = 'mipsel.*-linux'

inherit kernel

KERNEL_OUTPUT = "arch/mips/brcm-boards/bcm947xx/compressed/piggy"
CMDLINE = "root=/dev/mtdblock2 rootfstype=squashfs,jffs2 console=ttyS0,115200"

KERNEL_OBJECT_SUFFIX = ".o"  ### should be auto

export CFLAGS_KERNEL="-fno-delayed-branch "

do_unpack_extra(){
	# copy kernel source which is maintained in openwrt via cvs
	cp -pPR ${WORKDIR}/kernel-source/* ${S}
	# copy binary wlan driver
	cp -pPR ${WORKDIR}/wl/*.o ${S}/drivers/net/wl
	# copy proprietary et source
	cp -pPR ${WORKDIR}/et/* ${S}/drivers/net/et
	cp -pPR ${WORKDIR}/et/*.h ${S}/include/
}
addtask unpack_extra after do_unpack before do_patch

do_configure_prepend() {
	install -m 0644 ${WORKDIR}/linux.config ${S}/.config
	echo "CONFIG_CMDLINE=\"${CMDLINE}\"" >> ${S}/.config

	sed -i -e 's/@expr length/@-expr length/' ${S}/Makefile
	sed -i -e "s,\-mcpu=,\-mtune=,g;" ${S}/arch/mips/Makefile
}

do_deploy() {
	install -d ${DEPLOY_DIR_IMAGE}
	cat ${KERNEL_OUTPUT} | lzma e -si -so -eos > \
		${DEPLOY_DIR_IMAGE}/wrt-kernel-${PV}.lzma
}

COMPATIBLE_MACHINE = "wrt54"
