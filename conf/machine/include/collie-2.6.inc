PREFERRED_PROVIDER_virtual/kernel = "linux-rp"

SERIAL_CONSOLE = "115200 ttySA0"
MACHINE_FEATURES = "kernel26 apm pcmcia screen irda usbgadget keyboard touchscreen wifi vfat"

MACHINE_EXTRA_RDEPENDS = "kernel-modules"

MACHINE_POSTPROCESS_COMMAND = "zaurus_make_installkit"

zaurus_make_installkit () {
    cd ${DEPLOY_DIR_IMAGE}
    rm -rf ${DEPLOY_DIR_IMAGE}/${IMAGE_NAME}-installkit/
    mkdir ${IMAGE_NAME}-installkit/
    # Get the latest kernel using the zImage-<machine>.bin symlink
    cp zImage-${MACHINE}.bin ${IMAGE_NAME}-installkit/zImage.bin
    if [ "${MACHINE}" = "spitz" ]; then
        cp gnu-tar ${IMAGE_NAME}-installkit/
        cp ${IMAGE_NAME}.rootfs.tar.gz ${IMAGE_NAME}-installkit/hdimage1.tgz
    else
        [ -f ${IMAGE_NAME}.rootfs.jffs2 ] && cp ${IMAGE_NAME}.rootfs.jffs2 ${IMAGE_NAME}-installkit/initrd.bin
    fi

    # All zaurus machines except collie need updater.sh
    if [ "${MACHINE}" != "collie" ]; then
        cp updater.sh.${MACHINE} ${IMAGE_NAME}-installkit/updater.sh
    fi

    tar czf ${DEPLOY_DIR_IMAGE}/${IMAGE_NAME}-installkit.tgz ${IMAGE_NAME}-installkit/
    md5sum ${DEPLOY_DIR_IMAGE}/${IMAGE_NAME}-installkit.tgz > ${DEPLOY_DIR_IMAGE}/${IMAGE_NAME}-installkit.tgz.md5
    rm -rf ${DEPLOY_DIR_IMAGE}/${IMAGE_NAME}-installkit/
}


