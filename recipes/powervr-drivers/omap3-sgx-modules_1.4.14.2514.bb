DESCRIPTION = "Kernel drivers for the PowerVR SGX chipset found in the omap3 SoCs"
LICENSE = "GPLv2"

PR_append = "a"

# download required binary distribution from:
# http://software-dl.ti.com/dsps/forms/export.html?prod_no=/OMAP35x_Graphics_SDK_setuplinux_3_01_00_02.bin

TI_BIN_UNPK_CMDS="Y: qY:workdir:Y"
require ../ti/ti-eula-unpack.inc

SGXPV = "3_01_00_02"
IMGPV = "1.4.14.2514"
BINFILE := "OMAP35x_Graphics_SDK_setuplinux_${SGXPV}.bin"

SRC_URI = "file://OMAP35x_Graphics_SDK_setuplinux_${SGXPV}.bin \
           file://0001-Compile-fixes-for-recent-kernels.patch;patch=1 \
"
S = "${WORKDIR}/OMAP35x_Graphics_SDK_${SGXPV}/GFX_Linux_KM"

inherit module

PVRBUILD = "release"

INHIBIT_PACKAGE_STRIP = "1"

MAKE_TARGETS = " BUILD=${PVRBUILD}"

do_install() {
	mkdir -p ${D}/lib/modules/${KERNEL_VERSION}/kernel/drivers/gpu/pvr
	cp ${S}/pvrsrvkm.ko \
	   ${S}/services4/3rdparty/dc_omap3430_linux/omaplfb.ko  \
	   ${S}/services4/3rdparty/bufferclass_ti/bufferclass_ti.ko \
	   ${D}/lib/modules/${KERNEL_VERSION}/kernel/drivers/gpu/pvr
}
