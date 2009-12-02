DESCRIPTION = "Kernel drivers for the PowerVR SGX chipset found in the omap3 SoCs"
LICENSE = "GPLv2"

inherit module

SRC_URI = "file://omap3-sgx-modules-${PV}.tar.bz2 \
           file://0002-Compile-fixes-for-DSS2.patch;patch=1 \
           file://rotation-dss2.patch;patch=1 \
           file://build_es3.x_sgx.patch;patch=1 \
           file://proc-interface.patch;patch=1 \
	   file://0001-Compile-fixes-for-recent-kernels.patch;patch=1 \
"

PVRBUILD = "release"

INHIBIT_PACKAGE_STRIP = "1"

MAKE_TARGETS = " BUILD=${PVRBUILD}"

do_install() {
	mkdir -p ${D}/lib/modules/${KERNEL_VERSION}/kernel/drivers/gpu/pvr
	cp ${S}/pvrsrvkm.ko ${S}/services4/3rdparty/dc_omap3430_linux/omaplfb.ko ${D}/lib/modules/${KERNEL_VERSION}/kernel/drivers/gpu/pvr
}
