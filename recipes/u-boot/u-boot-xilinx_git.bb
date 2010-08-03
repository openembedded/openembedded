require u-boot.inc
PR = "r0"

# Prefered u-boot from mainstream since has generic support for
# ppc405, ppc440 and microblaze
# SRC_URI = "git://git.denx.de/u-boot.git;protocol=git"
# SRCREV = "8bd9dbdfa3a19f322810e2ad9e6d6551602d8afe"
SRC_URI = "git://git.xilinx.com/u-boot-xlnx.git;protocol=git"
SRCREV = "26e999650cf77c16f33c580abaadab2532f5e8b2"

inherit xilinx-bsp

TARGET_BOARD = "${@map_target(bb.data.getVar('TARGET_ARCH', d, 1), d)}"
UBOOT_TARGET = "${@uboot_target(bb.data.getVar('TARGET_ARCH', d, 1), d)}"
export UBOOT_MACHINE = "${@uboot_machine(bb.data.getVar('TARGET_ARCH', d, 1), d)}"

S = "${WORKDIR}/git"
