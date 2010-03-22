SECTION = "kernel"
DESCRIPTION = "Linux kernel for OMAP1-based Palm devicess"
LICENSE = "GPLv2"

COMPATIBLE_MACHINE = "(palmz71|palmtt|palmtt2)"

inherit kernel

DEPENDS = ""

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/kernel/v2.6/linux-2.6.22.tar.bz2 \
           http://www.muru.com/linux/omap/patches/patch-2.6.22-omap1.bz2;patch=1 \
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
