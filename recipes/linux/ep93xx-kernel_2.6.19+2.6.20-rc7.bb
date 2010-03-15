DESCRIPTION = "Linux Kernel for Cirrus Logic ep39xx compatible machines"
SECTION = "kernel"
LICENSE = "GPLv2"
PR = "r1"

COMPATIBLE_MACHINE = "ep93xx"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-2.6.19.tar.bz2 \
	   ${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/testing/patch-2.6.20-rc7.bz2;patch=1 \
           file://dynamic-phys-offset-2.6.20-rc7.diff;patch=1 \ 
           file://defconfig \
		   "

S = "${WORKDIR}/linux-2.6.19"

inherit kernel




do_configure() {
        rm -f ${S}/.config

        if [ ! -e ${WORKDIR}/defconfig ]; then
                die "No default configuration for ${MACHINE} available."
        fi


        if [ "${TARGET_OS}" == "linux-gnueabi" -o  "${TARGET_OS}" == "linux-uclibceabi" ]; then
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
