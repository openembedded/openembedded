########################
# Zaurus common settings
########################

ERASEBLOCKSIZE = "0x4000"
ERASEBLOCKSIZE_akita = "0x20000"

# Warning! SL-C3000 has "0x4000" (16MiB NAND) 
# C3100 and C3200 have same 128MiB NAND device as akita
ERASEBLOCKSIZE_spitz = "0x20000"

IMAGE_FSTYPES += "jffs2 tar.gz"

# kernel now supports favourlzo
IMAGE_CMD_jffs2 = "mkfs.jffs2 --root=${IMAGE_ROOTFS} --faketime -m favourlzo \
                   --output=${T}/${IMAGE_NAME}.rootfs.jffs2 --pad --little-endian --eraseblock=${ERASEBLOCKSIZE} -n \
                   && sumtool -i ${T}/${IMAGE_NAME}.rootfs.jffs2 \
                   -o ${T}/${IMAGE_NAME}.rootfs.jffs2.summary \
                   --eraseblock=${ERASEBLOCKSIZE} -l -p; \
                   cat ${T}/${IMAGE_NAME}.rootfs.jffs2 > ${DEPLOY_DIR_IMAGE}/${IMAGE_NAME}.rootfs.jffs2; \
                   rm ${T}/${IMAGE_NAME}.rootfs.jffs2; \
                   cat ${T}/${IMAGE_NAME}.rootfs.jffs2.summary > ${DEPLOY_DIR_IMAGE}/${IMAGE_NAME}.rootfs.summary.jffs2; \
                   rm ${T}/${IMAGE_NAME}.rootfs.jffs2.summary;"

EXTRA_IMAGEDEPENDS += "zaurus-installer"

IMAGE_DEVICE_TABLES = "files/device_table-minimal.txt \
                       files/device_table_add-scsi.txt \
                       files/device_table_add-loop.txt \
                       "

#########
# xserver (FIXME: xserver-xorg is in testing on spitz)
#########

PREFERRED_PROVIDER_virtual/xserver = "xserver-kdrive"
XSERVER = "xserver-kdrive-fbdev"

# c7x0 uses kdrive-imageon_1.2.0
PREFERRED_PROVIDER_virtual/xserver_c7x0 = "xserver-kdrive-imageon"
XSERVER_c7x0 = "xserver-kdrive-imageon"

# collie uses kdrive-fbdev
PREFERRED_PROVIDER_virtual/xserver_collie = "xserver-kdrive"
XSERVER_collie = "xserver-kdrive-fbdev"

# FIXME xserver-kdrive 1.3.0.0 is still the only working version ?
PREFERRED_PROVIDER_virtual/xserver_akita = "xserver-kdrive-1300"
XSERVER_akita = "xserver-kdrive-1300-fbdev"

# spitz uses xserver-xorg
PREFERRED_PROVIDER_virtual/xserver_spitz = "xserver-xorg"
XSERVER_spitz = "xserver-xorg xf86-video-fbdev xf86-input-keyboard xf86-input-mouse xf86-input-evdev"
PREFERRED_PROVIDER_virtual/libgl_spitz = "mesa-dri"


########
# kernel
########

PREFERRED_PROVIDER_virtual/kernel = "linux"

# Default bootloader expects "zImage", use "uImage" for u-boot
# Note: kexecboot can boot both kind of images
ZAURUS_KERNEL_IMAGETYPE ?= "zImage"
KERNEL_IMAGETYPE = "${ZAURUS_KERNEL_IMAGETYPE}"

# sane defaults for devices with only 32Mb RAM (see man xz)
XZ_COMPRESSION_LEVEL = "-e -7"

# kernel bootlogo
LOGO_SIZE = '${@base_conditional("GUI_MACHINE_CLASS", "bigscreen", "vga", "qvga", d)}'

################
# machine tuning
################

TARGET_ARCH = "arm"

SERIAL_CONSOLE = "115200 ttyS0"
SERIAL_CONSOLE_collie = "115200 ttySA0"

PCMCIA_MANAGER ?= "pcmciautils"

CMDLINE_akita = "console=ttyS0,115200n8 console=tty1 fbcon=rotate:1"
CMDLINE_c7x0 = "console=ttyS0,115200n8 console=tty1"
CMDLINE_collie = "console=ttySA0,115200n8 console=tty1 mem=64M fbcon=rotate:1"
CMDLINE_poodle = "console=ttyS0,115200n8 console=tty1 fbcon=rotate:1"
CMDLINE_spitz = "console=ttyS0,115200n8 console=tty1 fbcon=rotate:1"
CMDLINE_tosa = "console=ttyS0,115200n8 console=tty1"

MACHINE_FEATURES = "kernel26 apm alsa pcmcia irda usbgadget keyboard touchscreen screen vfat ext2"
MACHINE_FEATURES_append_akita = " usbhost"
MACHINE_FEATURES_append_spitz = " usbhost"
MACHINE_FEATURES_append_tosa  = " usbhost wifi "

MACHINE_EXTRA_RDEPENDS = "zaurusd mtd-utils nandlogical"
MACHINE_EXTRA_RDEPENDS_collie = "zaurusd"

# Still actual? OHCI suspend/resume fixup
# MACHINE_EXTRA_RRECOMMENDS_tosa = "apm-tosa-suspendfix"

##################################
# build kexecboot kernel while
# making sure rootfs is compatible
##################################

require conf/machine/include/initramfs-kexecboot.inc

# FIXME
# blindly import from linux-rp.inc (2.6.2x)
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
# Fixme ? module-snd for tosa
