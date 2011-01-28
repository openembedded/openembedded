# untested and huge change from 1.4.x
DEFAULT_PREFERENCE = "-1"

DESCRIPTION = "Kernel drivers for the PowerVR SGX chipset found in the omap3 SoCs"
LICENSE = "GPLv2"

# download required binary distribution from:
# http://software-dl.ti.com/dsps/dsps_public_sw/sdo_sb/targetcontent/gfxsdk/latest/index_FDS.html
# see libgles-omap3.inc for detailed installation instructions

TI_BIN_UNPK_CMDS="Y: qY:workdir:Y"
require ../ti/ti-eula-unpack.inc

SGXPV = "4_03_00_01"
IMGPV = "1.6.16.3977"
BINFILE := "Graphics_SDK_setuplinux_${SGXPV}.bin"

inherit module

MACHINE_KERNEL_PR_append = "h"

SRC_URI = "http://software-dl.ti.com/dsps/dsps_public_sw/sdo_sb/targetcontent/gfxsdk/${SGXPV}/exports/Graphics_SDK_setuplinux_${SGXPV}.bin \
"
SRC_URI[md5sum] = "4163ee51bc05689b6f61e7eadf5ab9cf"
SRC_URI[sha256sum] = "1afe0dc4974c3c0a0ccf267a531d0964459d1cdf1929e732958230641973da94"

S = "${WORKDIR}/Graphics_SDK_${SGXPV}/GFX_Linux_KM"

PVRBUILD = "release"

PACKAGE_STRIP = "no"

TI_PLATFORM_omap3 = "omap3630"
TI_PLATFORM_ti816x = "ti8168"

MODULESLOCATION_omap3 = "dc_omap3430_linux"
MODULESLOCATION_ti816x = "dc_ti8168_linux"

MAKE_TARGETS = " BUILD=${PVRBUILD} TI_PLATFORM=${TI_PLATFORM}"

do_install() {
	mkdir -p ${D}/lib/modules/${KERNEL_VERSION}/kernel/drivers/gpu/pvr
	cp ${S}/pvrsrvkm.ko \
	   ${S}/services4/3rdparty/${MODULESLOCATION}/omaplfb.ko  \
	   ${S}/services4/3rdparty/bufferclass_ti/bufferclass_ti.ko \
	   ${D}/lib/modules/${KERNEL_VERSION}/kernel/drivers/gpu/pvr
}
