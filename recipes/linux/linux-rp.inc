DESCRIPTION = "2.6 Linux Development Kernel for Zaurus devices and iPAQ hx2750."
SECTION = "kernel"
LICENSE = "GPLv2"

inherit kernel

DEPENDS_append_collie = " bc-native"
RPROVIDES_kernel-base += "hostap-modules"

DOSRC = "http://www.do13.de/openzaurus/patches"
RPSRC = "http://www.rpsys.net/openzaurus/patches/archive"
JLSRC = "http://www.cs.wisc.edu/~lenz/zaurus/files"
BASRC = "http://www.orca.cx/zaurus/patches"
CHSRC = "http://oz.drigon.com/patches"
TKSRC = "http://www.informatik.hu-berlin.de/~tkunze/zaurus/patches"

COMPATIBLE_HOST = "(arm|i.86).*-linux"
COMPATIBLE_MACHINE = '(collie|poodle|c7x0|akita|spitz|tosa|hx2000|qemuarm|qemux86|bootcdx86|htcuniversal|zylonite)'

# Enable OABI compat for people stuck with obsolete userspace
ARM_KEEP_OABI ?= "1"

# Quirk for udev greater or equal 141
UDEV_GE_141 ?= "0"

KERNEL_DEFCONFIG ?= "defconfig-${MACHINE}"

CMDLINE_CON = "console=ttyS0,115200n8 console=tty1 noinitrd"
CMDLINE_CON_collie = "console=ttySA0,115200n8 console=tty1 noinitrd"
CMDLINE_CON_qemuarm = "console=ttyAMA0,115200n8 console=tty1 noinitrd"
CMDLINE_CON_zylonite = "console=ttyS0,38400"
CMDLINE_ROOT ?= "root=/dev/mtdblock2 rootfstype=jffs2"
CMDLINE_ROOT_collie = "root=/dev/mmcblk0p1 rootfstype=ext2 rootdelay=3 rw"
CMDLINE_ROOT_spitz ?= "root=/dev/hda1 rootfstype=ext3 rootdelay=1 rw"
#CMDLINE_ROOT_spitz = "root=/dev/mmcblk0p2 rootfstype=ext2 rootdelay=3 rw"
CMDLINE_OTHER = "dyntick=enable"
CMDLINE_DEBUG = '${@base_conditional("DISTRO_TYPE", "release", "quiet", "debug",d)}'

##############################################################
# Configure memory/ramdisk split for collie
#
export mem = '${@bb.data.getVar("COLLIE_MEMORY_SIZE",d,1) or "64"}'
export rd  = '${@bb.data.getVar("COLLIE_RAMDISK_SIZE",d,1) or "0"}'

CMDLINE_MEM_collie = "mem=${mem}M"
CMDLINE_MEM_zylonite = "mem=64M"
CMDLINE_ROTATE_spitz = "fbcon=rotate:1"
CMDLINE_ROTATE_akita = "fbcon=rotate:1"
CMDLINE_ROTATE_collie = "fbcon=rotate:1"
CMDLINE_ROTATE_poodle = "fbcon=rotate:1"
CMDLINE = "${CMDLINE_CON} ${CMDLINE_ROOT} ${CMDLINE_MEM} ${CMDLINE_ROTATE} ${CMDLINE_OTHER} ${CMDLINE_DEBUG}"

###############################################################
# module configs specific to this kernel
#
module_autoload_pxaficp_ir = "pxaficp_ir"
module_autoload_snd-pcm-oss = "snd-pcm-oss"
module_autoload_pcmcia_core = "pcmcia_core"
module_autoload_pxa2xx_cs = "pxa2xx_cs"
module_autoload_ohci-hcd_tosa = "ohci-hcd"
module_autoload_snd-soc-corgi_c7x0 = "snd-soc-corgi"
module_autoload_snd-soc-spitz_akita = "snd-soc-spitz"
module_autoload_snd-soc-spitz_spitz = "snd-soc-spitz"
module_autoload_snd-soc-poodle_poodle = "snd-soc-poodle"
module_autoload_locomo-spi_collie = "locomo-spi"
module_autoload_mmc_block_collie = "mmc_block"
module_autoload_mmc_spi = "mmc-spi"
module_autoload_locomokbd_collie = "locomokbd"
module_autoload_sa1100-cs_collie = "sa1100_cs"
module_autoload_collie-ts_collie = "collie-ts"
module_autoload_leds-locomo_collie = "leds-locomo"
module_autoload_power_collie = "power"

do_configure() {
	rm -f ${S}/.config

	if [ "${MACHINE}" = "tosa" ]; then
		gcc_version=`${KERNEL_CC} -dumpversion`		
		if [ "${gcc_version}" = "4.0.1" ] || [ "${gcc_version}" = "4.0.2" ]; then
			die "tosa kernel wont work with gcc 4.0.x"
		fi
	fi

	if [ ! -e ${WORKDIR}/${KERNEL_DEFCONFIG} ]; then
		die "No default configuration for ${MACHINE} available."
	fi

	if [ "${MACHINE}" = "collie" ]; then
		mempos=`echo "obase=16; $mem * 1024 * 1024" | bc`
		rdsize=`echo "$rd * 1024" | bc`
		total=`expr $mem + $rd`
		addr=`echo "obase=16; ibase=16; C0000000 + $mempos" | bc`
	 	if [ "$rd" = "0" ]
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

	if [ "${TARGET_OS}" = "linux-gnueabi" -o "${TARGET_OS}" = "linux-uclibceabi" ]; then
		echo "CONFIG_AEABI=y"                   >> ${S}/.config
		if [ "${ARM_KEEP_OABI}" = "1" ] ; then
			echo "CONFIG_OABI_COMPAT=y"             >> ${S}/.config
		else
			echo "# CONFIG_OABI_COMPAT is not set"  >> ${S}/.config
		fi
	else 
		echo "# CONFIG_AEABI is not set"        >> ${S}/.config
		echo "# CONFIG_OABI_COMPAT is not set"  >> ${S}/.config
	fi

	if [ "${DISTRO}" = "poky" -a "${MACHINE}" != "collie" ]; then
		echo "CONFIG_LOGO=y"                          >> ${S}/.config
		echo "CONFIG_LOGO_OHAND_CLUT224=y"            >> ${S}/.config
		echo "# CONFIG_LOGO_OZ240_CLUT224 is not set" >> ${S}/.config
		echo "# CONFIG_LOGO_OZ480_CLUT224 is not set" >> ${S}/.config
		echo "# CONFIG_LOGO_OZ640_CLUT224 is not set" >> ${S}/.config
		echo "# CONFIG_LOGO_LINUX_CLUT224 is not set" >> ${S}/.config
	else 
		echo "# CONFIG_LOGO is not set"               >> ${S}/.config
		echo "# CONFIG_LOGO_OHAND_CLUT224 is not set" >> ${S}/.config
		echo "# CONFIG_LOGO_LINUX_CLUT224 is not set" >> ${S}/.config
		echo "# CONFIG_LOGO_OZ240_CLUT224 is not set" >> ${S}/.config
		echo "# CONFIG_LOGO_OZ480_CLUT224 is not set" >> ${S}/.config
		echo "# CONFIG_LOGO_OZ640_CLUT224 is not set" >> ${S}/.config
	fi

	sed -e '/CONFIG_AEABI/d' \
	    -e '/CONFIG_OABI_COMPAT=/d' \
	    -e '/CONFIG_CMDLINE=/d' \
	    -e '/CONFIG_MTD_MTDRAM_SA1100=/d' \
	    -e '/CONFIG_MTDRAM_TOTAL_SIZE=/d' \
	    -e '/CONFIG_MTDRAM_ERASE_SIZE=/d' \
	    -e '/CONFIG_MTDRAM_ABS_POS=/d' \
	    -e '/CONFIG_LOGO=/d' \
	    -e '/CONFIG_LOGO_LINUX_CLUT224=/d' \
	    -e '/CONFIG_LOGO_OHAND_CLUT224=/d' \
	    -e '/CONFIG_LOGO_OZ240_CLUT224=/d' \
	    -e '/CONFIG_LOGO_OZ480_CLUT224=/d' \
	    -e '/CONFIG_LOGO_OZ640_CLUT224=/d' \
	    '${WORKDIR}/${KERNEL_DEFCONFIG}' >>'${S}/.config'

        echo 'CONFIG_LOCALVERSION=""' >>${S}/.config
        echo '# CONFIG_LOCALVERSION_AUTO is not set' >>${S}/.config

        #
        # Udev quirks
        #

        # Newer versions of udev mandate that sysfs doesn't have deprecated entries
        if [ "${UDEV_GE_141}" = "1" ] ; then
            sed -e /CONFIG_SYSFS_DEPRECATED/d \
                -e /CONFIG_SYSFS_DEPRECATED_V2/d \
                -i '${S}/.config'
            echo '# CONFIG_SYSFS_DEPRECATED is not set' >> ${S}/.config
            echo '# CONFIG_SYSFS_DEPRECATED_V2 is not set' >> ${S}/.config
        fi

	yes '' | oe_runmake oldconfig
}

SRC_URI[archive.md5sum] = "db95a49a656a3247d4995a797d333153"
SRC_URI[archive.sha256sum] = "108b2a3f2b05c0e57d1d0977619525e46f8d4b425aef4b38b47dcf94292f2dd2"
SRC_URI[rc4patch.md5sum] = "b5f96d823b1183ba0c4e61516e1a23c0"
SRC_URI[rc4patch.sha256sum] = "45994ebcdd4ed30b37c6fc0569ee69aee4f2ef9ed75857d0a3784ce3bfe92ffc"
SRC_URI[patch1.md5sum] = "a8b75ef4190dfc0afcfa8789d3e4c64c"
SRC_URI[patch1.sha256sum] = "3fed945b590db46a902fa434054b967dd1bf4af1ee5f5643e00d1d66a9d69543"
SRC_URI[patch2.md5sum] = "38e1ea5768cba4be72088a8a12d4b1af"
SRC_URI[patch2.sha256sum] = "837b95b128815f3d6689d2ecfbdc9a28023bae5f45879513f3b4c2ad12f459ee"
SRC_URI[patch3.md5sum] = "ebb78f58e9c84c73b90e9cbdde5f89d6"
SRC_URI[patch3.sha256sum] = "7578448fc2adbfc820158b2467dbb127ab012b3a97ad95366d8d1af002defbce"
SRC_URI[patch4.md5sum] = "896d3e29ab5715b7558b972fba626425"
SRC_URI[patch4.sha256sum] = "29f21117a17f945783f2eee5d5c89e10959fed44ac423ad9809d6afc0db5996c"
SRC_URI[patch5.md5sum] = "c1358d4c210d1d701b5b0d96d8e73c12"
SRC_URI[patch5.sha256sum] = "8697e76beb6ea44ce450e8cb9bed764803fe189eaea89e0aa72ebd1974bc52e4"
SRC_URI[patch6.md5sum] = "c70fa3e0184842e4f6822b7002eac33e"
SRC_URI[patch6.sha256sum] = "7ca39d0df0a102114eabcd39df94ff271d81a71d9ef9f61915ac0a04031b68d1"
SRC_URI[patch7.md5sum] = "33eed5a26b2776508500532c07956dc4"
SRC_URI[patch7.sha256sum] = "a93c7f0caa8e212a4515ce209918e250e80d2643317732d707d4f25649457545"
SRC_URI[patch8.md5sum] = "aeea5a2614fd8f9ae7d729d1ea1dddba"
SRC_URI[patch8.sha256sum] = "1bd129c7a68537533c77267992eaf490ff64bcc3d01c6f4b51343b8f266ae99e"
SRC_URI[patch9.md5sum] = "e10058b52841d138630b69b954bea0b9"
SRC_URI[patch9.sha256sum] = "779561c658ccb190f3a2cd7626e4a229834c5f9b093be8f7a06bbfaf12121b9c"
SRC_URI[patch10.md5sum] = "c51ae4d5fa800ec81660fdf5b776fae6"
SRC_URI[patch10.sha256sum] = "af92b078cb52f9c58964d49b074a5d09de601435c8e84cec817b636fc53c8eeb"
SRC_URI[patch12.md5sum] = "2c958056e0a82da4d85810ea51b9e07b"
SRC_URI[patch12.sha256sum] = "c8e0cf191fb60b26eb5481c24d162c3675c72bc940c42393af2f0b62897de90f"
SRC_URI[patch13.md5sum] = "a17be90788c4ccd6ee8253659b9321f8"
SRC_URI[patch13.sha256sum] = "56dfd5365848095793faa31ee1cf753c10891dd076944d3533b05c6547965134"
SRC_URI[patch14.md5sum] = "e897eb0dc64c2862091f97e20f580de6"
SRC_URI[patch14.sha256sum] = "66283a36122d77a4118a1b2e48af92c03ae09b3e53fe7875e7fe3db1486a522c"
SRC_URI[patch15.md5sum] = "05766128b2b0abdd01048e5e08430600"
SRC_URI[patch15.sha256sum] = "5fcd54adf3c8e7e99078a585683926224b5b49a99e4e675694621c3e08e6aad0"
SRC_URI[patch16.md5sum] = "7c766563674dec668baa5f650a14b7cd"
SRC_URI[patch16.sha256sum] = "3f78e714248cdaa0b83f530a3b7f80da02446b179e86fbb043d57c3e05ae0d7e"
SRC_URI[patch17.md5sum] = "959b91235cb2ebd45c5f3dc755c744fa"
SRC_URI[patch17.sha256sum] = "d56a238d3378012c965f25c12b136bd380f9faf27a6b5f08e79c252a724129a5"
SRC_URI[patch18.md5sum] = "ce6d8a7a25cc1c9593417746bcf84ca0"
SRC_URI[patch18.sha256sum] = "24aac1d158095007a10a47e38320a1618fab2d536f19caff94f4dd0ab29f306b"
SRC_URI[patch19.md5sum] = "9b69a1f5951ebd26d5b29ac326c5c414"
SRC_URI[patch19.sha256sum] = "8de4e1a8696c2f47ed1b9009498b4f89ba9dd3fbda6083531ef40c35ce001996"
SRC_URI[patch20.md5sum] = "b60a6035a3e84ba68771fef999ccc96f"
SRC_URI[patch20.sha256sum] = "fe3dcba12eab368a5c14e6c247886bcbaa3fafc662ea8de00fd579f956a21a71"
SRC_URI[patch21.md5sum] = "15a09026135382c716a11633344ba3c4"
SRC_URI[patch21.sha256sum] = "49521feb1a6e2bc9b355e93b3251e3c74ebe2327eb89c6e681347464e81e3664"
SRC_URI[patch22.md5sum] = "b67218e773a236631b41a1718049bbc7"
SRC_URI[patch22.sha256sum] = "f6ddc6636b2a8e4392dab43fdcfd9521e2d7f9022e56c39ecee66d50a94bdc98"
