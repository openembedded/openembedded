require linux.inc

DESCRIPTION = "Linux kernel for Xilinx ml507 platform"
KERNEL_RELEASE = "2.6.32+git"

COMPATIBLE_MACHINE = "xilinx-ml507"
DEFAULT_PREFERENCE = "-1"
DEFAULT_PREFERENCE_xilinx-ml507 = "1"

PV = "${KERNEL_RELEASE}"
PR = "r0"

SRCREV = "dc53725d22405e384b984d222542f526eaa9b829"
SRC_URI = "git://git.xilinx.com/linux-2.6-xlnx.git;protocol=git \
           file://defconfig"

inherit kernel xilinx-bsp

S = "${WORKDIR}/git"

do_configure_prepend() {
    install -m 0644 ${WORKDIR}/defconfig ${S}/.config
}
