DESCRIPTION = "strace is a system call tracing tool."
SECTION = "console/utils"
LICENSE = "BSD"
PR = "r9"

SRC_URI = "${SOURCEFORGE_MIRROR}/strace/strace-${PV}.tar.bz2 \
           file://glibc-2.5.patch \
           file://arm-eabi.patch \
           file://sh-arch-update.patch \
           file://sh-syscall-update.patch \
           file://strace-fix-arm-bad-syscall.patch \
           file://strace-undef-syscall.patch \
           file://strace-arm-no-cachectl.patch \
           file://strace-dont-include-linux-dirent-h.patch \
           file://mips-sigcontext.patch \
          "

# The strace-4.5.14-avr32.patch conflicts with some other patches.
# These patches are primarly for the ARM and SuperH, so we'll just
# not use them when building for the AVR32.
# The avr32 patch also includes the drop-ctl-proc.patch
# The AVR32 patches are from http://avr32linux.org/twiki/bin/view/Main/STrace
SRC_URI_avr32 = "${SOURCEFORGE_MIRROR}/strace/strace-${PV}.tar.bz2 \
     file://strace-4.5.14-avr32.patch \
     file://strace-4.5.14-avr32-add-syscalls-up-to-sysvipc.patch \
    "

inherit autotools

export INCLUDES = "-I. -I./linux"

SRC_URI[md5sum] = "09bcd5d00ece28f8154dec11cadfce3c"
SRC_URI[sha256sum] = "a6808914cbfead2595dfd061a0f14dcbb0a8bb645e3cfdfa5c247d7ded9e0e7d"
