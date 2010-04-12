SECTION = "kernel"
DESCRIPTION = "Linux kernel for OMAP1-based Palm devicess"
LICENSE = "GPLv2"

COMPATIBLE_MACHINE = "(palmz71|palmtt|palmtt2)"

inherit kernel

DEPENDS = ""

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-2.6.22.tar.bz2;name=kernel \
           http://www.muru.com/linux/omap/patches/patch-2.6.22-omap1.bz2;patch=1;name=patch \
	   file://defconfig"

S = "${WORKDIR}/linux-2.6.22"

PR = "r2"

do_configure() {

	if [ -f ${WORKDIR}/defconfig ]; then
		install -m 0644 ${WORKDIR}/defconfig ${S}/.config || die "No configuration for ${MACHINE} available."
	else
		die "No configuration for ${MACHINE} available."
	fi
	

	if [ "${TARGET_OS}" == "linux-gnueabi" -o  "${TARGET_OS}" == "linux-uclibceabi" ]; then
                echo "CONFIG_AEABI=y"                   >> ${S}/.config
                echo "CONFIG_OABI_COMPAT=y"             >> ${S}/.config
        else
                echo "# CONFIG_AEABI is not set"        >> ${S}/.config
                echo "# CONFIG_OABI_COMPAT is not set"  >> ${S}/.config
        fi
	yes '' | oe_runmake oldconfig

}

SRC_URI[kernel.md5sum] = "2e230d005c002fb3d38a3ca07c0200d0"
SRC_URI[kernel.sha256sum] = "73c10604c53f1a6ee65ef805293d23903696f8cef864f42d7de9506f0d2ba4c7"
SRC_URI[patch.md5sum] = "a05c1a0bc0d3a8a11aea38a069f477ec"
SRC_URI[patch.sha256sum] = "d787151df658a8bffcab9ad681f0dd23cf17b8919a5f7e35b15a73e56efbefc2"
