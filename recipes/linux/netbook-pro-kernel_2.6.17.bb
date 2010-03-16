DESCRIPTION = "Linux Kernel for Psion/Teklogix netbookpro  compatible machines"
SECTION = "kernel"
LICENSE = "GPLv2"
PR = "r2"

COMPATIBLE_MACHINE = "netbook-pro"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-2.6.17.tar.bz2 \
	http://linuxtogo.org/~koen/netbook-base-r3.patch;patch=1 \
	http://linuxtogo.org/~koen/netbook-pcon-r0.patch;patch=1 \
	http://linuxtogo.org/~koen/netbook-pcon-i2c-r1.patch;patch=1 \
	http://linuxtogo.org/~koen/defconfig \
		   "

S = "${WORKDIR}/linux-2.6.17"

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
