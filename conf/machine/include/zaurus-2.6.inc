# Zaurus specific configuration for kernel 2.6
# Additionally, clamshell specific stuff in zaurus-clamshell.inc

TARGET_ARCH = "arm"

MACHINE_KERNEL_VERSION = "2.6"

ERASEBLOCKSIZE = "0x4000"
ERASEBLOCKSIZE_akita = "0x20000"

EXTRA_IMAGECMD_jffs2 = "--little-endian --eraseblock=${ERASEBLOCKSIZE} --pad --faketime -n" 

EXTRA_IMAGEDEPENDS += "zaurus-updater"
KEXECBOOT_IMAGEDEPENDS = "zaurus-updater"

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

MACHINE_POSTPROCESS_COMMAND = "zaurus_make_installkit"

zaurus_make_installkit () {

	cd ${DEPLOY_DIR_IMAGE}
	rm -rf ${DEPLOY_DIR_IMAGE}/installkit-${MACHINE}/         
	mkdir installkit-${MACHINE}/

	[ -f "${KERNEL_IMAGETYPE}-kexecboot-${MACHINE}.bin" ] && cp ${KERNEL_IMAGETYPE}-kexecboot-${MACHINE}.bin installkit-${MACHINE}/${KERNEL_IMAGETYPE}

	cp updater.sh.${MACHINE} installkit-${MACHINE}/updater.sh
 
	tar czf ${DEPLOY_DIR_IMAGE}/installkit-${MACHINE}.tar.gz installkit-${MACHINE}/
	md5sum ${DEPLOY_DIR_IMAGE}/installkit-${MACHINE}.tar.gz > ${DEPLOY_DIR_IMAGE}/installkit-${MACHINE}.tar.gz.md5
	rm -rf ${DEPLOY_DIR_IMAGE}/installkit-${MACHINE}/     

}

require conf/machine/include/kexecboot.inc
