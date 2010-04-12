DESCRIPTION = "Linux Kernel for Cirrus Logic ep39xx compatible machines"
SECTION = "kernel"
LICENSE = "GPLv2"
PR = "r1"

COMPATIBLE_MACHINE = "ep93xx"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-2.6.19.tar.bz2;name=kernel \
	   ${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/testing/patch-2.6.20-rc7.bz2;patch=1;name=patch \
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

SRC_URI[kernel.md5sum] = "443c265b57e87eadc0c677c3acc37e20"
SRC_URI[kernel.sha256sum] = "c2fd6bcd2b7c1b3d37d64e4d1825703792a75474830a3db7d2dc603a8d392d58"
SRC_URI[patch.md5sum] = "b78873f8a3aff5bdc719fc7fb4c66a9b"
SRC_URI[patch.sha256sum] = "08cbaf4595195e5956b781bb5afbff9aa1c073fa887bea895f6b6de4ba332e79"
