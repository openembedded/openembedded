DESCRIPTION = "2.6 Linux Development Kernel for Zaurus devices."
SECTION = "kernel"
MAINTAINER = "Richard Purdie <rpurdie@rpsys.net>, Michael 'Mickey' Lauer <mickey@vanille.de>"
LICENSE = "GPL"
#KV = "${@bb.data.getVar('PV',d,True).split('-')[0]}"
KV = "${@bb.data.getVar('PV',d,True)}"
PR = "r2"

# ftp://ftp.kernel.org/pub/linux/kernel/v2.6/testing/linux-${KV}.tar.gz \
# http://www.kernel.org/pub/linux/kernel/people/alan/linux-2.6/2.6.10/patch-2.6.10-ac8.gz;patch=1 \
# http://www.kernel.org/pub/linux/kernel/v2.6/snapshots/patch-2.6.11-rc1-bk7.gz;patch=1 \

# Poodle is broken until JL rediffs against the latest patches
#http://www.rpsys.net/openzaurus/${KV}/jl1/poodle_base.patch;patch=1 \
#http://www.rpsys.net/openzaurus/${KV}/jl1/poodle_fb.patch;patch=1 \
#http://www.rpsys.net/openzaurus/${KV}/jl1/pxa-cpu.patch;patch=1 \
#http://www.rpsys.net/openzaurus/${KV}/jl1/locomo_kbd.patch;patch=1 \
#http://www.rpsys.net/openzaurus/${KV}/jl1/locomo_pm.patch;patch=1 \
#http://www.rpsys.net/openzaurus/${KV}/jl1/locomo_devices.patch;patch=1 \
#http://www.rpsys.net/openzaurus/${KV}/jl1/locomo_lcd.patch;patch=1 \
#http://www.rpsys.net/openzaurus/${KV}/jl1/collie_uart.patch;patch=1 \
#http://www.rpsys.net/openzaurus/${KV}/jl1/collie_batswitch.patch;patch=1 \
#http://www.rpsys.net/openzaurus/${KV}/jl1/collie_pcmcia.patch;patch=1 \
#http://www.rpsys.net/openzaurus/${KV}/jl1/sharp_mtd.patch;patch=1 \
#http://www.rpsys.net/openzaurus/${KV}/jl1/collie_use_sharp_mtd.patch;patch=1 \
#http://www.rpsys.net/openzaurus/${KV}/collie_scoop_pcmcia-r0.patch;patch=1 \



SRC_URI = "ftp://ftp.kernel.org/pub/linux/kernel/v2.6/testing/linux-${KV}.tar.gz \
           file://add-oz-release-string.patch;patch=1 \
           file://add-elpp-stuff.patch \
#http://www.rpsys.net/openzaurus/${KV}/jl1/pxa-linking-bug.patch;patch=1 \	   
http://www.cs.wisc.edu/~lenz/zaurus/files/patch-2.6.11-rc2-jl1.diff.gz;patch=1 \
http://www.cs.wisc.edu/~lenz/zaurus/files/poodle_fix_mtd_sharpsl_part.patch;patch=1 \
http://www.rpsys.net/openzaurus/${KV}/corgi_backlight-r12.patch;patch=1 \
http://www.rpsys.net/openzaurus/${KV}/corgi_base_extras2-r0.patch;patch=1 \
http://www.rpsys.net/openzaurus/${KV}/corgi_base_extras3-r0.patch;patch=1 \
http://www.rpsys.net/openzaurus/${KV}/corgi_base_extras1-r0.patch;patch=1 \
http://www.rpsys.net/openzaurus/${KV}/jffs2_longfilename-r0.patch;patch=1 \
http://www.rpsys.net/openzaurus/${KV}/corgi_kbd-r10.patch;patch=1 \
http://www.rpsys.net/openzaurus/${KV}/corgi_ts-r7.patch;patch=1 \
http://www.rpsys.net/openzaurus/${KV}/corgi_power-r15.patch;patch=1 \
http://www.rpsys.net/openzaurus/${KV}/corgi_power1-r0.patch;patch=1 \
http://www.rpsys.net/openzaurus/${KV}/ide_fixes-r1.patch;patch=1 \
http://www.rpsys.net/openzaurus/${KV}/mmc_sd-r3.patch;patch=1 \
file://defconfig-husky \
file://defconfig-collie \
file://defconfig-poodle \
file://defconfig-openzaurus-pxa-2.6 "

SRC_URI_append_husky = "http://www.rpsys.net/openzaurus/${KV}/corgi_keymap-r1.patch;patch=1 "
SRC_URI_append_openzaurus-pxa-2.6 = "http://www.rpsys.net/openzaurus/${KV}/corgi_keymap-r1.patch;patch=1 "
SRC_URI_append_collie = "http://www.rpsys.net/openzaurus/${KV}/jl1/collie_keymap.patch;patch=1 "

# Uncomment this to apply the Enhanced Linux Progress Patch.
# You also need to say VERBOSE=progress in /etc/default/rcS make it work
#APPLY_ELPP = "yes"

S = "${WORKDIR}/linux-${KV}"

inherit kernel

#
# Compensate for sucky bootloader on all Sharp Zaurus models
#
FILES_kernel = ""
ALLOW_EMPTY = 1 

EXTRA_OEMAKE = "OPENZAURUS_RELEASE=-${DISTRO_VERSION}"
COMPATIBLE_HOST = "arm.*-linux"

#
# Create the kernel command line (deprecated)
#
#CMDLINE_MTDPARTS_poodle   = "mtdparts=sharpsl-nand:7168k@0k(smf),22528k@7168k(root),-(home)"
#CMDLINE_MTDPARTS_corgi    = "mtdparts=sharpsl-nand:7168k@0k(smf),25600k@7168k(root),-(home)"
#CMDLINE_MTDPARTS_shepherd = "mtdparts=sharpsl-nand:7168k@0k(smf),25600k@7168k(root),-(home)"
#CMDLINE_MTDPARTS_husky    = "mtdparts=sharpsl-nand:7168k@0k(smf),54272k@7168k(root),-(home) mem=64M"
#CMDLINE_MTDPARTS_tosa     = "mtdparts=sharpsl-nand:7168k@0k(smf),28672k@7168k(root),-(home) EQUIPMENT=2"

CMDLINE_CON = "console=ttyS0,115200n8 console=tty0 noinitrd"
CMDLINE_ROOT = "root=/dev/mtdblock2 rootfstype=jffs2 "

# configure memory/ramdisk split on collie
export mem = ${@bb.data.getVar("COLLIE_MEMORY_SIZE",d,1) or "32"}
export rd  = ${@bb.data.getVar("COLLIE_RAMDISK_SIZE",d,1) or "32"}

CMDLINE_MEM_collie = "mem=${mem}M"
CMDLINE = "${CMDLINE_CON} ${CMDLINE_ROOT} ${CMDLINE_MTDPARTS} ${CMDLINE_MEM}"

do_configure() {
	install -m 0644 ${WORKDIR}/defconfig-${MACHINE} ${S}/.config || die "No default configuration for ${MACHINE} available."

	if [ "${MACHINE}" == "collie" ]
	then
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

	if [ "${APPLY_ELPP}" == "yes" ]
	then
		patcher -i -R ${FILESDIR}/add-elpp-stuff.patch
		echo "# Enhanced Linux Progress Patch"	>> ${S}/.config
		echo "CONFIG_FB_ELPP=y"			>> ${S}/.config
		echo "CONFIG_LOGO=y"			>> ${S}/.config
		echo "CONFIG_LOGO_LINUX_CLUT224=y"	>> ${S}/.config
	fi

    yes '' | oe_runmake oldconfig
}

do_deploy() {
        install -d ${DEPLOY_DIR}/images
        install -m 0644 arch/${ARCH}/boot/${KERNEL_IMAGETYPE} ${DEPLOY_DIR}/images/${KERNEL_IMAGETYPE}-${MACHINE}-${DATETIME}.bin
}

do_deploy[dirs] = "${S}"

addtask deploy before do_build after do_compile
