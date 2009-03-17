require linux.inc

# Mark archs/machines that this kernel supports
DEFAULT_PREFERENCE = "-1"
DEFAULT_PREFERENCE_mpc8313e-rdb = "1"
DEFAULT_PREFERENCE_mpc8315e-rdb = "1"

PR = "r6"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-2.6.24.tar.bz2 \
           http://kamikaze.waninkoko.info/patches/2.6.24/kamikaze1/broken-out/squashfs-lzma-2.6.24.patch;patch=1 \
           file://powerpc-clockres.patch;patch=1 \
           file://defconfig"

#           file://sysctl_missing_include.patch;patch=1 \

S = "${WORKDIR}/linux-2.6.24"

SRC_URI_append_mpc8313e-rdb = " \
           ${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/patch-2.6.24.7.bz2;patch=1;p=1 \
           ${KERNELORG_MIRROR}/pub/linux/kernel/projects/rt/patch-2.6.24.7-rt11.bz2;patch=1;p=1 \
           file://leds-cpu-activity.patch;patch=1 \
           file://leds-cpu-activity-powerpc.patch;patch=1 \
	file://mpc8313e-rdb-leds.patch;patch=1"
#	file://mpc831x-nand.patch;patch=1 \
#	file://mpc8313e-rdb-rtc.patch;patch=1 "


# override the device tree source file from linux.inc, as the patches below
# introduce new variants. -- Leon Woestenberg
KERNEL_DEVICETREE_mpc8315e-rdb = "arch/${ARCH}/boot/dts/mpc8315erdb_default.dts"

# Patch series taken from MPC8315ERDB_20080627-ltib.iso, available as-is from
# Freescale's web site. Patches also available at www.bitshrine.org, which I
# use here. -- Leon Woestenberg

SRC_URI_append_mpc8315e-rdb = " \
${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/patch-2.6.24.3.bz2;patch=1;p=1 \
${KERNELORG_MIRROR}/pub/linux/kernel/projects/rt/older/patch-2.6.24.3-rt3.bz2;patch=1;p=1 \
http://www.bitshrine.org/gpp/linux-fsl-2.6.24.3-MPC8315ERDB-platform-support.patch;patch=1 \
http://www.bitshrine.org/gpp/linux-fsl-2.6.24.3-MPC8315ERDB-add-all-interrupts.patch;patch=1 \
http://www.bitshrine.org/gpp/linux-fsl-2.6.24.3-MPC8315ERDB-Realtek-821x-phy.patch;patch=1 \
http://www.bitshrine.org/gpp/linux-fsl-2.6.24.3-MPC8315ERDB-fix-gianfar.patch;patch=1 \
http://www.bitshrine.org/gpp/linux-fsl-2.6.24.3-MPC8315ERDB-Gianfar-buffer-recycling.patch;patch=1 \
http://www.bitshrine.org/gpp/linux-fsl-2.6.24.3-MPC8315ERDB-Gianfar-performance.patch;patch=1 \
http://www.bitshrine.org/gpp/linux-fsl-2.6.24.3-MPC8315ERDB-sata-support.patch;patch=1 \
http://www.bitshrine.org/gpp/linux-fsl-2.6.24.3-MPC8315ERDB-fsl-serdes-support.patch;patch=1 \
http://www.bitshrine.org/gpp/linux-fsl-2.6.24.3-MPC8315ERDB-pcie-INTx-support.patch;patch=1 \
http://www.bitshrine.org/gpp/linux-fsl-2.6.24.3-MPC8315ERDB-ipic-msi.patch;patch=1 \ 
http://www.bitshrine.org/gpp/linux-fsl-2.6.24.3-MPC8315ERDB-usb-support.patch;patch=1 \
http://www.bitshrine.org/gpp/linux-fsl-2.6.24.3-MPC8315ERDB-power-management.patch;patch=1 \
http://www.bitshrine.org/gpp/linux-fsl-2.6.24.3-MPC8315ERDB-usb-power-mangement.patch;patch=1 \
http://www.bitshrine.org/gpp/linux-fsl-2.6.24.3-MPC8315ERDB-NAND-flash.patch;patch=1 \
http://www.bitshrine.org/gpp/linux-fsl-2.6.24.3-MPC8315ERDB-elbc-jffs2-on-nand.patch;patch=1 \
http://www.bitshrine.org/gpp/linux-fsl-2.6.24.3-MPC8315ERDB-Codewarrior-kernel-debug.patch;patch=1 \
http://www.bitshrine.org/gpp/linux-fsl-2.6.24.3-MPC8315ERDB-otg.patch;patch=1 \
http://www.bitshrine.org/gpp/linux-fsl-2.6.24.3-MPC831x-LFC.patch;patch=1 \
http://www.bitshrine.org/gpp/linux-fsl-2.6.24.3-MPC8315ERDB-TDM.patch;patch=1 \
http://www.bitshrine.org/gpp/linux-fsl-2.6.24.3-MPC8315ERDB-tdm-test-modules.patch;patch=1 \
http://www.bitshrine.org/gpp/linux-fsl-2.6.24.3-MPC8315ERDB-spi-for-tdm-module.patch;patch=1 \
http://www.bitshrine.org/gpp/linux-fsl-2.6.24.3-MPC8315ERDB-port-mutiplier-in-sata.patch;patch=1 \ 
http://www.bitshrine.org/gpp/linux-fsl-2.6.24.3-MPC8315ERDB-performance-monitor.patch;patch=1 \
http://www.bitshrine.org/gpp/linux-fsl-2.6.24.3-MPC8315ERDB-ieee-1588.patch;patch=1 \
http://www.bitshrine.org/gpp/linux-fsl-2.6.24.3-MPC8315ERDB-DTS.patch;patch=1 \
http://www.bitshrine.org/gpp/linux-fsl-2.6.24.3-MPC8315ERDB-sata-pm.patch;patch=1 \
http://www.bitshrine.org/gpp/linux-fsl-2.6.24.3-MPC8315ERDB-fix-large-file-transfer.patch;patch=1 \
http://www.bitshrine.org/gpp/linux-fsl-2.6.24.3-MPC8315ERDB-default-configuration.patch;patch=1 \
"

# Last 5 patches in the series, for crypto stuff. The 2nd of these is created
# against crypto/ocf/ and thus needs a proper rebase against the base dir.
# This remains a todo. -- Leon Woestenberg.
#SRC_URI_append_mpc8315e-rdb = " \
#http://www.bitshrine.org/gpp/ocf-linux-26-20071215.patch.gz;patch=1 \
#http://www.bitshrine.org/gpp/ocf-linux-20071215-20080427.diff;patch=1 \
#http://www.bitshrine.org/gpp/linux-fsl-2.6.24-OCF-fsl_soc-2.patch;patch=1 \
#http://www.bitshrine.org/gpp/linux-2.6.24-Openswan-2.4.12.patch;patch=1 \
#http://www.bitshrine.org/gpp/linux-fsl-2.6.24.3-openswan-sysctl.patch;patch=1 \
#"
