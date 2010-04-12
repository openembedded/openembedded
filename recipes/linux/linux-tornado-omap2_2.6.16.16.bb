DESCRIPTION = "Linux kernel for HTC Tornado/Typhoon/Hurricane phones."
SECTION = "kernel"
LICENSE = "GPLv2"
PR = "r1"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-2.6.16.tar.bz2;name=kernel \
	   http://www.muru.com/linux/omap/patches/old/patch-2.6.16-omap2.bz2;patch=1;name=patch \
           file://linux-2.6.16.16.patch;patch=1 \
           file://tornado-20070320.patch;patch=1 \
           file://defconfig"

S = "${WORKDIR}/linux-2.6.16"

inherit kernel

COMPATIBLE_MACHINE = "htctornado"

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

        sed     -e '/CONFIG_AEABI/d' \
                -e '/CONFIG_OABI_COMPAT=/d' \
                '${WORKDIR}/defconfig' >>'${S}/.config'

        yes '' | oe_runmake oldconfig

}

SRC_URI[kernel.md5sum] = "9a91b2719949ff0856b40bc467fd47be"
SRC_URI[kernel.sha256sum] = "1200dcc7e60fcdaf68618dba991917a47e41e67099e8b22143976ec972e2cad7"
SRC_URI[patch.md5sum] = "b8de4aa518292ad3aef913645898218a"
SRC_URI[patch.sha256sum] = "34beecc0dd156267e8004fb79efea9bf97e1157ed597bdde1841c16def2e9195"
