require linux.inc

DESCRIPTION = "Linux kernel for Xilinx ml507 platform"
KERNEL_RELEASE = "2.6.33+git"

COMPATIBLE_MACHINE = "xilinx-ml507"
DEFAULT_PREFERENCE = "-1"
DEFAULT_PREFERENCE_xilinx-ml507 = "1"

PV = "${KERNEL_RELEASE}"
PR = "r1"

SRCREV = "17431547113100a3ae0a622b9f76ad17fb76eb56"
SRC_URI = "git://git.xilinx.com/linux-2.6-xlnx.git;protocol=git \
           file://xilinxfb.patch \
           file://defconfig"

inherit kernel xilinx-bsp

S = "${WORKDIR}/git"

do_configure_prepend() {
    install -m 0644 ${WORKDIR}/defconfig ${S}/.config
}
