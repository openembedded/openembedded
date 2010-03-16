SECTION = "kernel"
DESCRIPTION = "Linux kernel for the MX21ADS"
LICENSE = "GPLv2"
PR = "r2"

PV = "2.6.18+2.6.19-rc6"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-2.6.18.tar.bz2 \
    ${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/testing/patch-2.6.19-rc6.bz2;patch=1 \
    http://opensource.wolfsonmicro.com/~lg/linux-2.6-mx21/mx21ads-2.6.19rc6-lg1.patch.bz2;patch=1 \
    file://mx21ads_defconfig"

S = "${WORKDIR}/linux-2.6.18"

COMPATIBLE_HOST = 'arm.*-linux'
COMPATIBLE_MACHINE = "mx21ads"

inherit kernel

ARCH = "arm"
RPROVIDES_kernel-image += "hostap-modules"

#CMDLINE_ROOT = "root=/dev/mtdblock4 rootfstype=jffs2 mem=32M@0x00000000"
#CMDLINE = "${CMDLINE_ROOT} ${CMDLINE_CONSOLE}"

do_configure_prepend() {
	install -m 0644 ${WORKDIR}/mx21ads_defconfig ${S}/defconfig

        if [ "${TARGET_OS}" == "linux-gnueabi" -o  "${TARGET_OS}" == "linux-uclibceabi" ]; then
                echo "CONFIG_AEABI=y"                   >> ${S}/.config
                echo "CONFIG_OABI_COMPAT=y"             >> ${S}/.config
        else
                echo "# CONFIG_AEABI is not set"        >> ${S}/.config
                echo "# CONFIG_OABI_COMPAT is not set"  >> ${S}/.config
        fi

        sed     -e '/CONFIG_AEABI/d' \
                -e '/CONFIG_OABI_COMPAT=/d' \
                '${S}/defconfig' >>'${S}/.config'


#	echo "CONFIG_CMDLINE=\"${CMDLINE}\"" >> ${S}/.config

	yes '' | oe_runmake oldconfig

}
