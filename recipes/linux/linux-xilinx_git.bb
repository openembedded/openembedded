require linux.inc

DESCRIPTION = "Linux kernel for Xilinx platforms"

COMPATIBLE_MACHINE = "xilinx-virtex4|xilinx-virtex5|xilinx-mb-gen"
DEFAULT_PREFERENCE = "-1"
DEFAULT_PREFERENCE_xilinx-virtex4 = "1"
DEFAULT_PREFERENCE_xilinx-virtex5 = "1"
DEFAULT_PREFERENCE_xilinx-mb-gen = "1"

PV = "2.6.33+git"
PR = "r0"

SRCREV = "17431547113100a3ae0a622b9f76ad17fb76eb56"
SRC_URI = "git://git.xilinx.com/linux-2.6-xlnx.git;protocol=git \
           file://xilinxfb-update-tft-comp.patch \
	    file://defconfig"

PV_xilinx-mb-gen = "2.6.34+git"
SRCREV_xilinx-mb-gen = "382e23534109197daddbcbcdf5aae75c674638e7"
SRC_URI_xilinx-mb-gen = "git://developer.petalogix.com/linux-2.6-microblaze.git;protocol=git \
                       file://defconfig"

inherit kernel xilinx-bsp

TARGET_BOARD = "${@map_target(bb.data.getVar('TARGET_ARCH', d, 1), d)}"
KERNEL_DEVICETREE_xilinx-virtex4 = "arch/${ARCH}/boot/dts/virtex${TARGET_BOARD}.dts"
KERNEL_DEVICETREE_xilinx-virtex5 = "arch/${ARCH}/boot/dts/virtex${TARGET_BOARD}.dts"
KERNEL_DEVICETREE_xilinx-mb-gen = "arch/${ARCH}/platform/generic/${TARGET_BOARD}.dts"

S = "${WORKDIR}/git"

do_configure_prepend() {
    install -m 0644 ${WORKDIR}/defconfig ${S}/.config
}
