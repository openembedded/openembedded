DESCRIPTION = "Kernel drivers for the PowerVR SGX chipset found in the omap3 SoCs"
LICENSE = "GPLv2"

PR = "r6"

inherit module

SRC_URI = "http://dominion.thruhere.net/koen/OE/omap3-sgx-modules-${PV}.tar.bz2 \
           file://0001-Compile-fixes-for-DSS2.patch;patch=1 \
           file://0001-New-build-system-for-SGX.patch;patch=1 \
           file://spurious-irq-fix.diff;patch=1 \
"

PVRBUILD = "release"

MAKE_TARGETS = " BUILD=${PVRBUILD}"

do_compile_prepend() {
	find ${S} -name "*.*o" | xargs rm
}

do_install() {
	mkdir -p ${D}/lib/modules/${KERNEL_VERSION}/kernel/drivers/gpu/pvr
	cp ${S}/pvrsrvkm.ko ${S}/services4/3rdparty/dc_omap3430_linux/omaplfb.ko ${D}/lib/modules/${KERNEL_VERSION}/kernel/drivers/gpu/pvr
}
