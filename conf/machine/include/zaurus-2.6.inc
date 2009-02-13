# Zaurus specific configuration for kernel 2.6
# Additionally, clamshell specific stuff in zaurus-clamshell.inc

TARGET_ARCH = "arm"

MACHINE_KERNEL_VERSION = "2.6"

ERASEBLOCKSIZE = "0x4000"
ERASEBLOCKSIZE_akita = "0x20000"

EXTRA_IMAGECMD_jffs2 = "--little-endian --eraseblock=${ERASEBLOCKSIZE} --pad --faketime -n" 

ZAURUS-UPDATER = "zaurus-updater"
EXTRA_IMAGEDEPENDS += "${ZAURUS-UPDATER}"

SERIAL_CONSOLE = "115200 ttyS0"

PREFERRED_PROVIDER_virtual/kernel = "linux-rp"
PREFERRED_PROVIDER_virtual/xserver = "xserver-kdrive"
PREFERRED_PROVIDER_virtual/xserver_c7x0 = "xserver-kdrive-imageon"

PCMCIA_MANAGER ?= "pcmciautils"

MACHINE_FEATURES = "kernel26 apm alsa pcmcia irda usbgadget keyboard touchscreen screen vfat"
MACHINE_FEATURES_append_tosa  = " usbhost wifi "
MACHINE_FEATURES_append_akita = " usbhost "
MACHINE_FEATURES_append_spitz = " usbhost ext2 "

MACHINE_EXTRA_RDEPENDS = "zaurusd"
MACHINE_EXTRA_RRECOMMENDS_c7x0   = "kernel-module-snd-soc-corgi kernel-module-pxa2xx-cs kernel-module-pcmcia"
MACHINE_EXTRA_RRECOMMENDS_akita  = "kernel-module-snd-soc-spitz kernel-module-pxa2xx-cs kernel-module-pcmcia"
MACHINE_EXTRA_RRECOMMENDS_spitz  = "kernel-module-snd-soc-spitz"
MACHINE_EXTRA_RRECOMMENDS_poodle = "kernel-module-snd-soc-poodle kernel-module-pxa2xx-cs kernel-module-pcmcia"

GUI_MACHINE_CLASS = "bigscreen"
GUI_MACHINE_CLASS_poodle = "smallscreen"

KERNEL_IMAGE_MAXSIZE = "1294336"

MACHINE_POSTPROCESS_COMMAND = "zaurus_make_installkit"

zaurus_make_installkit () {
    cd ${DEPLOY_DIR_IMAGE}
    rm -rf ${DEPLOY_DIR_IMAGE}/${IMAGE_NAME}-installkit/         
    mkdir ${IMAGE_NAME}-installkit/

    # Get the latest kernel using the zImage-<machine>.bin symlink
    if [ "${@base_contains('MACHINE_FEATURES', 'kexecboot', 'true', 'false',d)}" = "true" ]; then
	    [ -f "zImage-kexecboot-${MACHINE}.bin" ] && cp zImage-kexecboot-${MACHINE}.bin ${IMAGE_NAME}-installkit/zImage
	    # we need also tgz for mmc or cf cards
	    cp ${IMAGE_NAME}.rootfs.tar.gz ${IMAGE_NAME}-installkit/image.tgz
    else
	    cp zImage-${MACHINE}.bin ${IMAGE_NAME}-installkit/zImage
    fi

    if [ "${MACHINE}" = "spitz" ]; then
        cp gnu-tar ${IMAGE_NAME}-installkit/
        cp ${IMAGE_NAME}.rootfs.tar.gz ${IMAGE_NAME}-installkit/hdimage1.tgz
    else
        [ -f ${IMAGE_NAME}.rootfs.jffs2 ] && cp ${IMAGE_NAME}.rootfs.jffs2 ${IMAGE_NAME}-installkit/initrd.bin
    fi

    cp updater.sh.${MACHINE} ${IMAGE_NAME}-installkit/updater.sh
   
 
    tar czf ${DEPLOY_DIR_IMAGE}/${IMAGE_NAME}-installkit.tgz ${IMAGE_NAME}-installkit/
    md5sum ${DEPLOY_DIR_IMAGE}/${IMAGE_NAME}-installkit.tgz > ${DEPLOY_DIR_IMAGE}/${IMAGE_NAME}-installkit.tgz.md5
    rm -rf ${DEPLOY_DIR_IMAGE}/${IMAGE_NAME}-installkit/     
}

KERNEL_IMAGETYPE ?= "zImage"

require conf/machine/include/kexecboot.inc
