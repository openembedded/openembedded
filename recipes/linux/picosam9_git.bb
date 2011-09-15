DESCRIPTION = "Kernel for picoSAM9 board (http://www.mini-box.com/pico-SAM9G45-X)"
HOMEPAGE = "http://arm.mini-box.com"
KV = "2.6.32"
SRCREV = "5d564f090ee99a0570a2cc912ebc30b65922f7bb"
PV = "${KV}+gitr${SRCREV}"
PR = "r0"

require linux.inc

# For Angstrom and Android Eclair (for a Android Gingerbread compatible kernel use
# branch=minibox-picopc-2.6.32-gingerbread)
SRC_URI = "\
  git://gitorious.org/picopc-kernel/kernel.git;protocol=git;branch=minibox-picopc-2.6.32 \
  file://defconfig \
"

S = "${WORKDIR}/git"

COMPATIBLE_HOST = "arm.*-linux"
COMPATIBLE_MACHINE = "picosam9"
# mem=128M@xxxx - picoSAM9 has 2x128Mb memory banks at different adresses and uses
#                 sparsemem memory model to use both banks
# init=/init  - compatibility option for starting android init.If not found standard /linuxrc is
#               executed
# rootdelay=1 - wait 1 second before mounting the root fs (some delay exists between
#               root device showing up and partition detection).
# rootwait=1  - wait for the root device to show up (picosam9 boots from microSD(MMC))
# loglevel=7  - get the kernel messages on atmel DBGU serial port console
# androidboot.hardware=picopc - compatibility option for booting android
#                               (loading of init.picopc.rc and libhardware libs)
CMDLINE = "mem=128M@0x20000000 mem=128M@0x70000000 console=ttyS0,115200 root=/dev/mmcblk0p2 rw init=/init rootdelay=1 rootwait=1 loglevel=7 androidboot.hardware=picopc"
KERNEL_IMAGETYPE = "uImage"
ARM_KEEP_OABI = "1"
