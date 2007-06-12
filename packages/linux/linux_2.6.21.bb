DESCRIPTION = "Linux Kernel"
SECTION = "kernel"
LICENSE = "GPL"
DEPENDS_kb9202 = "u-boot"
PR = "r3"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-${PV}.tar.bz2 \
           file://defconfig \
	   "

SRC_URI_append_simpad = "\
           file://linux-2.6.21-SIMpad-cs3-simpad.patch;patch=1 \
           file://linux-2.6.21-SIMpad-mq200.patch;patch=1 \
           file://linux-2.6.21-SIMpad-serial-and-gpio_keys.patch;patch=1 \
           file://linux-2.6.21-SIMpad-ucb1x00-switches.patch;patch=1 \
           file://linux-2.6.21-pcmcia-device-to-platform-driver.patch;patch=1 \
           "
SRC_URI_append_kb9202 = "http://maxim.org.za/AT91RM9200/2.6/2.6.21-at91.patch.gz;patch=1"

inherit kernel

KERNEL_IMAGETYPE_progear = "bzImage"
KERNEL_IMAGETYPE_simpad = "zImage"
KERNEL_IMAGETYPE_kb9202 = "uImage"
KERNEL_IMAGETYPE_at32stk1000 = "uImage"

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

