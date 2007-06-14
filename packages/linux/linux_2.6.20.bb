DESCRIPTION = "Linux Kernel"
SECTION = "kernel"
LICENSE = "GPL"

# These devices need mkimage to generate a kernel image
DEPENDS_at91sam9263ek = "u-boot-mkimage-gta01-native"

PR = "r7"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-${PV}.tar.bz2 \
           file://defconfig"

SRC_URI_append_n2100 = "\
	   file://n2100-r8169-parity.patch;patch=1 \
	   file://rtc-rs5c372-n2100.patch;patch=1 \
	   "

SRC_URI_append_at91sam9263ek = " \
                                 http://maxim.org.za/AT91RM9200/2.6/${PV}-at91.patch.gz;patch=1 \
                                 http://www.at91.com/repFichier/Project-217/linux-${PV}-at91-exp.diff.bz2;patch=1 \
                               "

inherit kernel


KERNEL_IMAGETYPE = "bzImage"
KERNEL_IMAGETYPE_n2100 = "zImage"
KERNEL_IMAGETYPE_at91sam9263ek = "uImage"

do_configure_prepend() {
        if [ "${TARGET_OS}" == "linux-gnueabi" -o  "${TARGET_OS}" == "linux-uclibcgnueabi" ]; then
                echo "CONFIG_AEABI=y"                   >> ${S}/.config
                echo "CONFIG_OABI_COMPAT=y"             >> ${S}/.config
        else
                echo "# CONFIG_AEABI is not set"        >> ${S}/.config
                echo "# CONFIG_OABI_COMPAT is not set"  >> ${S}/.config
        fi

        sed -e '/CONFIG_AEABI/d' \
            -e '/CONFIG_OABI_COMPAT=/d' \
            '${WORKDIR}/defconfig' >>'${S}/.config'

        yes '' | oe_runmake oldconfig
}

do_install_prepend() {
        if test -e arch/${ARCH}/boot/Image ; then
             ln -f arch/arm/boot/Image arch/arm/boot/uImage
        fi

        if test -e arch/${ARCH}/boot/images/uImage ; then
             ln -f arch/arm/boot/images/uImage arch/arm/boot/uImage
        fi
}

do_install_append_n2100() {
	install -d ${DEPLOY_DIR_IMAGE}
	install -m 0644 ${S}/arch/${ARCH}/boot/${KERNEL_IMAGETYPE} ${DEPLOY_DIR_IMAGE}/${KERNEL_IMAGETYPE}-${PV}-${MACHINE}-${DATETIME}
}
