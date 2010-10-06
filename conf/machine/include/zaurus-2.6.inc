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

PREFERRED_PROVIDER_virtual/kernel = "linux-rp"

# Starting with 2.6.32 linux-rp is deprecated for some models
#PREFERRED_PROVIDER_virtual/kernel = "linux"
PREFERRED_PROVIDER_virtual/kernel_collie = "linux"
PREFERRED_PROVIDER_virtual/kernel_tosa = "linux"

# udev-141 is the latest version that works with linux-2.6.26-RP
PREFERRED_PROVIDER_udev-compat_akita = "udev-compat141"
PREFERRED_PROVIDER_udev-compat_spitz = "udev-compat141"
PREFERRED_PROVIDER_udev-compat_c7x0 = "udev-compat141"
PREFERRED_PROVIDER_udev-compat_poodle = "udev-compat141"

# Default bootloader expects "zImage", use "uImage" for u-boot
# Note: kexecboot can boot both kind of images
ZAURUS_KERNEL_IMAGETYPE ?= "zImage"
KERNEL_IMAGETYPE = "${ZAURUS_KERNEL_IMAGETYPE}"

# kernel bootlogo
LOGO_SIZE = '${@base_conditional("GUI_MACHINE_CLASS", "bigscreen", "vga", "qvga", d)}'

################
# machine tuning
################

TARGET_ARCH = "arm"

SERIAL_CONSOLE = "115200 ttyS0"
SERIAL_CONSOLE_collie = "115200 ttySA0"

PCMCIA_MANAGER ?= "pcmciautils"

MACHINE_FEATURES = "kernel26 apm alsa pcmcia irda usbgadget keyboard touchscreen screen vfat ext2"
MACHINE_FEATURES_append_akita = " usbhost "
MACHINE_FEATURES_append_spitz = " usbhost "
MACHINE_FEATURES_append_tosa  = " usbhost wifi "

MACHINE_EXTRA_RDEPENDS = "zaurusd mtd-utils nandlogical"
MACHINE_EXTRA_RDEPENDS_collie = "zaurusd"

# Fixme ? pcmcia and pxa2xx-cs are now compiled in kernel
# Fixme ? module-snd for collie
MACHINE_EXTRA_RRECOMMENDS_collie = ""
MACHINE_EXTRA_RRECOMMENDS_c7x0   = "kernel-module-snd-soc-corgi kernel-module-pxa2xx-cs kernel-module-pcmcia"
MACHINE_EXTRA_RRECOMMENDS_akita  = "kernel-module-snd-soc-spitz kernel-module-pxa2xx-cs kernel-module-pcmcia"
MACHINE_EXTRA_RRECOMMENDS_spitz  = "kernel-module-snd-soc-spitz kernel-module-pxa2xx-cs kernel-module-pcmcia"
MACHINE_EXTRA_RRECOMMENDS_poodle = "kernel-module-snd-soc-poodle kernel-module-pxa2xx-cs kernel-module-pcmcia"
# For tosa: OHCI suspend/resume fixup
# wlan-ng is now in kernel (2.6.29)
# Fixme ? module-snd for tosa
MACHINE_EXTRA_RRECOMMENDS_tosa = "apm-tosa-suspendfix"


##################################
# build kexecboot kernel while
# making sure rootfs is compatible
##################################

require conf/machine/include/initramfs-kexecboot.inc
