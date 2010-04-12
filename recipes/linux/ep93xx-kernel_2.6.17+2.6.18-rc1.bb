DESCRIPTION = "Linux Kernel for Cirrus Logic ep39xx compatible machines"
SECTION = "kernel"
LICENSE = "GPLv2"
PR = "r1"

COMPATIBLE_MACHINE = "ep93xx"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-2.6.17.tar.bz2;name=kernel \
	   ${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/testing/patch-2.6.18-rc1.bz2;patch=1;name=rcpatch \
	   ${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/snapshots/old/patch-2.6.18-rc1-git9.bz2;patch=1;name=patch \
	   http://www.wantstofly.org/~buytenh/ep93xx/derevo20.diff;pnum=1;patch=1;name=derevopatch \
           file://defconfig \
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
SRC_URI[rcpatch.md5sum] = "c4b487524edc3eb86385765d85625da4"
SRC_URI[rcpatch.sha256sum] = "d1e28b34a3732dc12e23df0311ccf6ddb4af9c0abba10a3ea7ceeaf009241f05"
SRC_URI[patch.md5sum] = "9033f9941b667f3e06d99ee1975a2ed7"
SRC_URI[patch.sha256sum] = "783edd55fe2dce02ea9349e8d2e103f7a3581f2b3c493a568d9551f13ee6e0c5"
SRC_URI[derevopatch.md5sum] = "9b74b3674613840e47dac4e36710fab6"
SRC_URI[derevopatch.sha256sum] = "0d879959995b5e8661500715ef0e9a6ca5b17b0a084bbc95f7a853537124635e"

