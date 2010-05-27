DESCRIPTION = "Kernel drivers for the PowerVR SGX chipset found in the omap3 SoCs"
LICENSE = "GPLv2"

PR_append = "a"

# download required binary distribution from:
# http://software-dl.ti.com/dsps/dsps_public_sw/sdo_sb/targetcontent/gfxsdk/latest/index_FDS.html
# see libgles-omap3.inc for detailed installation instructions

TI_BIN_UNPK_CMDS="Y: qY:workdir:Y"
require ../ti/ti-eula-unpack.inc

SGXPV = "3_01_00_02"
IMGPV = "1.4.14.2514"
BINFILE := "OMAP35x_Graphics_SDK_setuplinux_${SGXPV}.bin"

SRC_URI = "http://install.source.dir.local/OMAP35x_Graphics_SDK_setuplinux_${SGXPV}.bin \
           file://0001-Compile-fixes-for-recent-kernels.patch \
"
S = "${WORKDIR}/OMAP35x_Graphics_SDK_${SGXPV}/GFX_Linux_KM"

inherit module

PVRBUILD = "release"

PACKAGE_STRIP = "no"

MAKE_TARGETS = " BUILD=${PVRBUILD}"

do_install() {
	mkdir -p ${D}/lib/modules/${KERNEL_VERSION}/kernel/drivers/gpu/pvr
	cp ${S}/pvrsrvkm.ko \
	   ${S}/services4/3rdparty/dc_omap3430_linux/omaplfb.ko  \
	   ${S}/services4/3rdparty/bufferclass_ti/bufferclass_ti.ko \
	   ${D}/lib/modules/${KERNEL_VERSION}/kernel/drivers/gpu/pvr
}
