DESCRIPTION = "2.6 Linux Development Kernel for Zaurus devices."
SECTION = "kernel"
MAINTAINER = "Richard Purdie <rpurdie@rpsys.net>, Michael 'Mickey' Lauer <mickey@vanille.de>"
LICENSE = "GPL"
#KV = "${@bb.data.getVar('PV',d,True).split('-')[0]}"
KV = "${@bb.data.getVar('PV',d,True)}"

PR = "r2"

DOSRC="http://www.do13.in-berlin.de/openzaurus"
RPSRC="http://www.rpsys.net/openzaurus/patches"
JLSRC="http://www.cs.wisc.edu/~lenz/zaurus/files/"

# ftp://ftp.kernel.org/pub/linux/kernel/v2.6/testing/linux-${KV}.tar.gz \
# http://www.kernel.org/pub/linux/kernel/people/alan/linux-2.6/2.6.10/patch-2.6.10-ac8.gz;patch=1 \
# http://www.kernel.org/pub/linux/kernel/v2.6/snapshots/patch-2.6.11-rc1-bk7.gz;patch=1 \

# These have been left in the hope JL will split his patch series...
#${RPSRC}/jl1/poodle_base.patch;patch=1 \
#${RPSRC}/jl1/poodle_fb.patch;patch=1 \
#${RPSRC}/jl1/pxa-cpu.patch;patch=1 \
#${RPSRC}/jl1/locomo_kbd.patch;patch=1 \
#${RPSRC}/jl1/locomo_pm.patch;patch=1 \
#${RPSRC}/jl1/locomo_devices.patch;patch=1 \
#${RPSRC}/jl1/locomo_lcd.patch;patch=1 \
#${RPSRC}/jl1/collie_uart.patch;patch=1 \
#${RPSRC}/jl1/collie_batswitch.patch;patch=1 \
#${RPSRC}/jl1/collie_pcmcia.patch;patch=1 \
#${RPSRC}/jl1/sharp_mtd.patch;patch=1 \
#${RPSRC}/jl1/collie_use_sharp_mtd.patch;patch=1 \


SRC_URI = "ftp://ftp.kernel.org/pub/linux/kernel/v2.6/linux-2.6.10.tar.gz \
           ftp://ftp.kernel.org/pub/linux/kernel/v2.6/testing/patch-2.6.11-rc4.bz2;patch=2 \
           file://add-oz-release-string.patch;patch=1 \
           file://add-elpp-stuff.patch;patch=1 \
           ${RPSRC}/jl1/pxa-linking-bug.patch;patch=1 \	   
           ${JLSRC}/patch-2.6.11-rc2-jl1.diff.gz;patch=1 \
           ${JLSRC}/poodle_fix_mtd_sharpsl_part.patch;patch=1 \
           ${RPSRC}/rndis_fix-r0.patch;patch=1 \
           ${RPSRC}/w100_malloc-r1.patch;patch=1 \
           ${RPSRC}/corgi_kbd-r16.patch;patch=1 \
           ${RPSRC}/corgi_ts-r10.patch;patch=1 \
           ${RPSRC}/input_power-r1.patch;patch=1 \
           ${RPSRC}/corgi_base_extras1-r2.patch;patch=1 \
           ${RPSRC}/jffs2_longfilename-r0.patch;patch=1 \
           ${RPSRC}/corgi_power-r15.patch;patch=1 \
           ${RPSRC}/ide_fixes-r1.patch;patch=1 \
           ${RPSRC}/mmc_sd-r3.patch;patch=1 \
           ${RPSRC}/corgi_snd-r3.patch;patch=1 \
           ${DOSRC}/tc6393-device-r1.patch;patch=1 \
           ${DOSRC}/tc6393_nand-r1.patch;patch=1 \
           ${DOSRC}/tosa-machine-base-r1.patch;patch=1 \
           ${DOSRC}/tosa-keyboard-r1.patch;patch=1 \
           ${DOSRC}/tc6393fb-r0.patch;patch=1 \
           ${DOSRC}/tosa-power-r0.patch;patch=1 \
           file://defconfig-c7x0 \
           file://defconfig-collie \
           file://defconfig-poodle \
           file://defconfig-tosa "

SRC_URI_append_collie = " ${RPSRC}/jl1/collie_keymap.patch;patch=1 "
SRC_URI_append_c7x0 = " ${RPSRC}/corgi_power1-r0.patch;patch=1"
SRC_URI_append_tosa = " ${RPSRC}/corgi_power1-r0.patch;patch=1 \
                        ${DOSRC}/nand-readid-r0.patch;patch=1 \
                        ${DOSRC}/multiple-scoop-devices-r1.patch;patch=1 \
                        ${DOSRC}/tosa-pcmia-r0.patch;patch=1 \
                        ${DOSRC}/tosa-mmc-r0.patch;patch=1 \
                        ${DOSRC}/tosa-bl-r0.patch;patch=1 \
                        ${DOSRC}/tosa-udc-r0.patch;patch=1 \
                        ${DOSRC}/pxa-ac97-hh.org-r0.patch;patch=1 \
                        ${DOSRC}/tosa-ac97-r0.patch;patch=1 "

S = "${WORKDIR}/linux-2.6.10"

inherit kernel

##############################################################
# Compensate for sucky bootloader on all Sharp Zaurus models
#
FILES_kernel = ""
ALLOW_EMPTY = 1

EXTRA_OEMAKE = "OPENZAURUS_RELEASE=-${DISTRO_VERSION}"
COMPATIBLE_HOST = "arm.*-linux"

##############################################################
# Create the kernel command line (mtdparts deprecated)
#
#CMDLINE_MTDPARTS_poodle   = "mtdparts=sharpsl-nand:7168k@0k(smf),22528k@7168k(root),-(home)"
#CMDLINE_MTDPARTS_corgi    = "mtdparts=sharpsl-nand:7168k@0k(smf),25600k@7168k(root),-(home)"
#CMDLINE_MTDPARTS_shepherd = "mtdparts=sharpsl-nand:7168k@0k(smf),25600k@7168k(root),-(home)"
#CMDLINE_MTDPARTS_husky    = "mtdparts=sharpsl-nand:7168k@0k(smf),54272k@7168k(root),-(home) mem=64M"
#CMDLINE_MTDPARTS_tosa     = "mtdparts=sharpsl-nand:7168k@0k(smf),28672k@7168k(root),-(home) EQUIPMENT=2"

CMDLINE_CON = "console=ttyS0,115200n8 console=tty0 noinitrd"
CMDLINE_ROOT = "root=/dev/mtdblock2 rootfstype=jffs2 "
CMDLINE_ROOT_poodle = "root=/dev/mtdblock1 rootfstype=jffs2 "
CMDLINE_ROOT_tosa = "root=/dev/mtdblock1 rootfstype=jffs2 "

##############################################################
# Configure memory/ramdisk split for collie
#
export mem = ${@bb.data.getVar("COLLIE_MEMORY_SIZE",d,1) or "32"}
export rd  = ${@bb.data.getVar("COLLIE_RAMDISK_SIZE",d,1) or "32"}

CMDLINE_MEM_collie = "mem=${mem}M"
CMDLINE = "${CMDLINE_CON} ${CMDLINE_ROOT} ${CMDLINE_MTDPARTS} ${CMDLINE_MEM}"

###############################################################
# Enable or disable ELPP via local.conf - default is "no"
#
ENABLE_ELPP = ${@bb.data.getVar("OZ_KERNEL_ENABLE_ELPP",d,1) or "no"}

do_configure() {

	install -m 0644 ${WORKDIR}/defconfig-${MACHINE} ${S}/.config || die "No default configuration for ${MACHINE} available."

	if [ "${MACHINE}" == "collie" ]; then
		mempos=`echo "obase=16; $mem * 1024 * 1024" | bc`
		rdsize=`echo "$rd * 1024" | bc`
		total=`expr $mem + $rd`
		addr=`echo "obase=16; ibase=16; C0000000 + $mempos" | bc`
	 	if [ "$rd" == "0" ]
	 	then
		    echo "No RAMDISK"
			echo "# CONFIG_MTD_MTDRAM_SA1100 is not set" >> ${S}/.config
		else
		    echo "RAMDIR = $rdsize on $addr"
			echo "CONFIG_MTD_MTDRAM_SA1100=y"           >> ${S}/.config
			echo "CONFIG_MTDRAM_TOTAL_SIZE=$rdsize"     >> ${S}/.config
			echo "CONFIG_MTDRAM_ERASE_SIZE=1"           >> ${S}/.config
			echo "CONFIG_MTDRAM_ABS_POS=$addr"          >> ${S}/.config
		fi
	fi

	echo "CONFIG_CMDLINE=\"${CMDLINE}\"" >> ${S}/.config

	if [ "${ENABLE_ELPP}" == "yes" ]; then
                echo "# Enhanced Linux Progress Patch"  >> ${S}/.config
                echo "CONFIG_FB_ELPP=y"                 >> ${S}/.config
                echo "CONFIG_LOGO=y"                    >> ${S}/.config
                echo "CONFIG_LOGO_LINUX_CLUT224=y"      >> ${S}/.config
	else
		echo "# CONFIG_FB_ELPP is not set"	>> ${S}/.config
	fi

	yes '' | oe_runmake oldconfig
}

do_deploy() {
        install -d ${DEPLOY_DIR}/images
        install -m 0644 arch/${ARCH}/boot/${KERNEL_IMAGETYPE} ${DEPLOY_DIR}/images/${KERNEL_IMAGETYPE}-${MACHINE}-${DATETIME}.bin
}

do_deploy[dirs] = "${S}"

addtask deploy before do_build after do_compile
