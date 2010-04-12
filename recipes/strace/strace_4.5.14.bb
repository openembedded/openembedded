DESCRIPTION = "strace is a system call tracing tool."
SECTION = "console/utils"
LICENSE = "GPL"
PR = "r9"

SRC_URI = "${SOURCEFORGE_MIRROR}/strace/strace-${PV}.tar.bz2 \
           file://glibc-2.5.patch;patch=1 \
           file://arm-eabi.patch;patch=1 \
           file://sh-arch-update.patch;patch=1 \
           file://sh-syscall-update.patch;patch=1 \
           file://strace-fix-arm-bad-syscall.patch;patch=1 \
           file://strace-undef-syscall.patch;patch=1 \
           file://strace-arm-no-cachectl.patch;patch=1 \
           file://strace-dont-include-linux-dirent-h.patch;patch=1 \
           file://mips-sigcontext.patch;patch=1 \
          "

# The strace-4.5.14-avr32.patch conflicts with some other patches.
# These patches are primarly for the ARM and SuperH, so we'll just
# not use them when building for the AVR32.
# The avr32 patch also includes the drop-ctl-proc.patch
# The AVR32 patches are from http://avr32linux.org/twiki/bin/view/Main/STrace
SRC_URI_avr32 = "${SOURCEFORGE_MIRROR}/strace/strace-${PV}.tar.bz2 \
     file://strace-4.5.14-avr32.patch;patch=1 \
     file://strace-4.5.14-avr32-add-syscalls-up-to-sysvipc.patch;patch=1 \
    "

inherit autotools

export INCLUDES = "-I. -I./linux"

SRC_URI[md5sum] = "09bcd5d00ece28f8154dec11cadfce3c"
SRC_URI[sha256sum] = "a6808914cbfead2595dfd061a0f14dcbb0a8bb645e3cfdfa5c247d7ded9e0e7d"
