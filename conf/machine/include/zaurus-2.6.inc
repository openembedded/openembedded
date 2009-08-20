# Zaurus common settings
# Additionally, clamshell specific stuff in zaurus-clamshell.inc

TARGET_ARCH = "arm"

ERASEBLOCKSIZE = "0x4000"
ERASEBLOCKSIZE_akita = "0x20000"

# Warning! SL-C3000 seems to be "0x4000" (16m NAND) 
# C3100 and C3200 have same 128MB NAND device as akita
ERASEBLOCKSIZE_spitz = "0x20000"

EXTRA_IMAGECMD_jffs2 = "--little-endian --eraseblock=${ERASEBLOCKSIZE} --pad --faketime -n" 

EXTRA_IMAGEDEPENDS += "zaurus-installer"

SERIAL_CONSOLE = "115200 ttyS0"
SERIAL_CONSOLE_collie = "115200 ttySA0"

PREFERRED_PROVIDER_virtual/xserver = "xserver-kdrive"
PREFERRED_PROVIDER_virtual/xserver_c7x0 = "xserver-kdrive-imageon"
PREFERRED_PROVIDER_virtual/xserver_collie = "xserver-kdrive-fbdev"

PCMCIA_MANAGER ?= "pcmciautils"

IMAGE_FSTYPES += "jffs2 tar.gz"

MACHINE_FEATURES = "kernel26 apm alsa pcmcia irda usbgadget keyboard touchscreen screen vfat ext2"
MACHINE_FEATURES_append_akita = " usbhost "
MACHINE_FEATURES_append_spitz = " usbhost "
MACHINE_FEATURES_append_tosa  = " usbhost wifi "

MACHINE_EXTRA_RDEPENDS = "zaurusd mtd-utils nandlogical"
MACHINE_EXTRA_RDEPENDS_collie = "zaurusd"

# Here we just need snd modules
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

require conf/machine/include/zaurus-kernel.inc
require conf/machine/include/initramfs-kexecboot.inc
