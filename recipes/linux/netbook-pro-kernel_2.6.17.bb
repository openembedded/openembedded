DESCRIPTION = "Linux Kernel for Psion/Teklogix netbookpro  compatible machines"
SECTION = "kernel"
LICENSE = "GPLv2"
PR = "r2"

COMPATIBLE_MACHINE = "netbook-pro"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-2.6.17.tar.bz2;name=kernel \
	http://linuxtogo.org/~koen/netbook-base-r3.patch;patch=1;name=patch1 \
	http://linuxtogo.org/~koen/netbook-pcon-r0.patch;patch=1;name=patch2 \
	http://linuxtogo.org/~koen/netbook-pcon-i2c-r1.patch;patch=1;name=patch3 \
	http://linuxtogo.org/~koen/defconfig;name=config \
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

SRC_URI[kernel.md5sum] = "37ddefe96625502161f075b9d907f21e"
SRC_URI[kernel.sha256sum] = "ab0f647d52f124958439517df9e1ae0efda90cdb851f59f522fa1749f1d87d58"
SRC_URI[patch1.md5sum] = "b6e67a96e2f84bb70912da8c7e0d5ec1"
SRC_URI[patch1.sha256sum] = "e836560ffae454d4ca0c4cacd1f2a3e8528c5744372a77968bba3b947328ca38"
SRC_URI[patch2.md5sum] = "e69d763fc7e6ba9bae2f31780abfe6a0"
SRC_URI[patch2.sha256sum] = "eff1b8f117ef18f9685efb0c846666e7676e00239d26dd0763ee6b611408a9ca"
SRC_URI[patch3.md5sum] = "35737b77e07c83d69137fca3e4b3097d"
SRC_URI[patch3.sha256sum] = "f0112bf83be7d379276ae0c6f674d4f0cab692dd2fe089dbbfd05cf0e0319dc6"
SRC_URI[config.md5sum] = "0990daae2c846a01735922f9faa940df"
SRC_URI[config.sha256sum] = "a7b02a779a59de06c2f55a47db01d414ac52e952eb6e21e6b5f9c34e3b36a8ab"
