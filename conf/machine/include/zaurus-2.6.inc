# Zaurus specific configuration for kernel 2.6
# Additionally, clamshell specific stuff in zaurus-clamshell.inc

TARGET_ARCH = "arm"

MACHINE_KERNEL_VERSION = "2.6"

ERASEBLOCKSIZE = "0x4000"
ERASEBLOCKSIZE_akita = "0x20000"

# Warning! SL-C3000 seems to be "0x4000" (16m NAND) 
# C3100 and C3200 have same 128MB NAND device as akita
ERASEBLOCKSIZE_spitz = "0x20000"

EXTRA_IMAGECMD_jffs2 = "--little-endian --eraseblock=${ERASEBLOCKSIZE} --pad --faketime -n" 

EXTRA_IMAGEDEPENDS += "zaurus-installer"

SERIAL_CONSOLE = "115200 ttyS0"

PREFERRED_PROVIDER_virtual/kernel = "linux-rp"
PREFERRED_PROVIDER_virtual/kernel_tosa = "linux"
PREFERRED_PROVIDER_virtual/xserver = "xserver-kdrive"
PREFERRED_PROVIDER_virtual/xserver_c7x0 = "xserver-kdrive-imageon"

PCMCIA_MANAGER ?= "pcmciautils"

IMAGE_FSTYPES += "jffs2"

MACHINE_FEATURES = "kernel26 apm alsa pcmcia irda usbgadget keyboard touchscreen screen vfat ext2"
MACHINE_FEATURES_append_tosa  = " usbhost wifi "
MACHINE_FEATURES_append_akita = " usbhost "
MACHINE_FEATURES_append_spitz = " usbhost "

MACHINE_EXTRA_RDEPENDS = "zaurusd mtd-utils nandlogical"

# Fixme ?
#########
# Here we just need snd modules
MACHINE_EXTRA_RRECOMMENDS_c7x0   = "kernel-module-snd-soc-corgi kernel-module-pxa2xx-cs kernel-module-pcmcia"
MACHINE_EXTRA_RRECOMMENDS_akita  = "kernel-module-snd-soc-spitz kernel-module-pxa2xx-cs kernel-module-pcmcia"
MACHINE_EXTRA_RRECOMMENDS_spitz  = "kernel-module-snd-soc-spitz kernel-module-pxa2xx-cs kernel-module-pcmcia"
MACHINE_EXTRA_RRECOMMENDS_poodle = "kernel-module-snd-soc-poodle kernel-module-pxa2xx-cs kernel-module-pcmcia"

KERNEL_IMAGE_MAXSIZE = "1294336"

ZAURUS_KERNEL_IMAGETYPE ?= "zImage"
KERNEL_IMAGETYPE = "${ZAURUS_KERNEL_IMAGETYPE}"

require conf/machine/include/kexecboot.inc
