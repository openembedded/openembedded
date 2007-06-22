DESCRIPTION = "Linux Kernel"
SECTION = "kernel"
LICENSE = "GPL"

# These devices need mkimage to generate a kernel image 
DEPENDS_kb9202 = "u-boot-mkimage-gta01-native"
DEPENDS_at32stk1000 = "u-boot-mkimage-gta01-native" 
DEPENDS_atngw100 = "u-boot-mkimage-gta01-native"
DEPENDS_at91sam9263ek = "u-boot-mkimage-gta01-native"

inherit kernel

KERNEL_IMAGETYPE_progear = "bzImage"
KERNEL_IMAGETYPE_simpad = "zImage"
KERNEL_IMAGETYPE_kb9202 = "uImage"
KERNEL_IMAGETYPE_atngw100 = "uImage"
KERNEL_IMAGETYPE_at32stk1000 = "uImage"
KERNEL_IMAGETYPE_at91sam9263ek = "uImage"

# Specify the commandline for you device here:

#boot from mmc
CMDLINE_at91sam9263ek = "mem=64M console=ttyS0,115200 root=/dev/mmcblk0p1 rootfstype=ext2 rootdelay=5"
#boot from nfs
#CMDLINE_at91sam9263ek = "mem=64M console=ttyS0,115200 root=301 root=/dev/nfs nfsroot=172.20.3.1:/data/at91 ip=172.20.0.5:::255.255.0.0"

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
        install -m 0644 arch/${ARCH}/boot/${KERNEL_IMAGETYPE} ${DEPLOY_DIR_IMAGE}/${KERNEL_IMAGETYPE}-${PV}-${PR}-${MACHINE}-${DATETIME}.bin
        tar -cvzf ${DEPLOY_DIR_IMAGE}/modules-${KERNEL_RELEASE}-${PR}-${MACHINE}.tgz -C ${D} lib
        
        if test "x${KERNEL_IMAGETYPE}" = "xuImage" ; then 
            ${OBJCOPY} -O binary -R .note -R .comment -S vmlinux linux.bin
            rm -f linux.bin.gz
            gzip -9 linux.bin
            uboot-mkimage -A ${ARCH} -O linux -T kernel -C gzip -a 20008000 -e 20008000 -n "${DISTRO_NAME} Kernel for ${MACHINE}" -d linux.bin.gz ${DEPLOY_DIR_IMAGE}/uImage-${PV}-${PR}-${MACHINE}-${DATETIME}.bin
            rm -f linux.bin.gz
        fi
}

do_deploy[dirs] = "${S}"

addtask prepatch before do_patch after do_unpack
addtask deploy before do_package after do_install

