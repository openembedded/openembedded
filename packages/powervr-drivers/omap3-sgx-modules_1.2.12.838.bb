DESCRIPTION = "Kernel drivers for the PowerVR SGX chipset found in the omap3 SoCs"
LICENSE = "GPLv2"

inherit module

SRC_URI = "http://dominion.thruhere.net/koen/OE/omap3-sgx-modules-${PV}.tar.bz2 \
"

MAKE_TARGETS = "BUILD=debug"

do_compile_prepend() {
	cd ${S}/eurasiacon/build/linux/omap3430_linux/kbuild/
}

do_install() {
	cd ${S}/eurasiacon/build/linux/omap3430_linux/kbuild/
	mkdir -p ${D}/lib/modules/${KERNEL_VERSION}/kernel/drivers/gpu/pvr
	cp ${WORKDIR}/${PN}-${PV}/eurasiacon/binary_omap3430_linux_debug/*.ko ${D}/lib/modules/${KERNEL_VERSION}/kernel/drivers/gpu/pvr
}
