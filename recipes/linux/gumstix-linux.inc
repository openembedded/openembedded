DESCRIPTION = "Linux kernel for custom configurations"
SECTION = "kernel"
LICENSE = "GPL"
PR = "r1"

inherit kernel

DEPENDS += " \
           u-boot-mkimage-openmoko-native \
          "

KERNEL_IMAGE_BASE_NAME = ${KERNEL_IMAGETYPE}-${PV}-${PR}-${MACHINE}

S = "${WORKDIR}/linux-${PV}"
do_deploy[dirs] = "${S}"

do_configure_prepend() {
        echo "" > ${S}/.config

        if [ "${TARGET_OS}" == "linux-gnueabi" -o  "${TARGET_OS}" == "linux-uclibcgnueabi" ]; then
                echo "CONFIG_AEABI=y"                   >> ${S}/.config
                echo "CONFIG_OABI_COMPAT=y"             >> ${S}/.config
        else
                echo "# CONFIG_AEABI is not set"        >> ${S}/.config
                echo "# CONFIG_OABI_COMPAT is not set"  >> ${S}/.config
        fi

        echo "CONFIG_CMDLINE=\"${CMDLINE}\"" >> ${S}/.config

        sed -e '/CONFIG_AEABI/d' \
            -e '/CONFIG_OABI_COMPAT=/d' \
            -e '/CONFIG_CMDLINE=/d' \
            < '${WORKDIR}/defconfig' >>'${S}/.config'

       yes '' | oe_runmake oldconfig
}

do_sizecheck() {
        if [ ! -z "${KERNEL_IMAGE_MAXSIZE}" ]; then
            size=`ls -l arch/${ARCH}/boot/${KERNEL_IMAGETYPE} | awk '{ print $5}'`
            if [ $size -ge ${KERNEL_IMAGE_MAXSIZE} ]; then
                    rm arch/${ARCH}/boot/${KERNEL_IMAGETYPE}
                    die  "This kernel (size=$size) is too big for your device. Please reduce the size of the kernel by making more of it modular."
            fi
        fi
}

do_install_prepend() {
        if test -e arch/${ARCH}/boot/Image ; then
             ln -f arch/${ARCH}/boot/Image arch/${ARCH}/boot/uImage
        fi

        if test -e arch/${ARCH}/boot/images/uImage ; then
             ln -f arch/${ARCH}/boot/images/uImage arch/${ARCH}/boot/uImage
        fi
}

do_deploy() {
        install -d ${DEPLOY_DIR_IMAGE}
        install -m 0644 arch/${ARCH}/boot/${KERNEL_IMAGETYPE} ${DEPLOY_DIR_IMAGE}/${KERNEL_IMAGE_BASE_NAME}.bin
        tar -cvzf ${DEPLOY_DIR_IMAGE}/modules-${KERNEL_RELEASE}-${PR}-${MACHINE}.tgz -C ${D} lib
        
        if test "x${KERNEL_IMAGETYPE}" = "xuImage" ; then 
            ${OBJCOPY} -O binary -R .note -R .comment -S arch/${ARCH}/boot/compressed/vmlinux linux.bin
            uboot-mkimage -A ${ARCH} -O linux -T kernel -C none -a ${UBOOT_ENTRYPOINT} -e ${UBOOT_ENTRYPOINT} -n "${DISTRO_NAME}/${PV}/${MACHINE}" -d linux.bin ${DEPLOY_DIR_IMAGE}/${KERNEL_IMAGE_BASE_NAME}.bin
            rm -f linux.bin

        fi
}

addtask sizecheck before do_install after do_compile
addtask deploy before do_package after do_install


