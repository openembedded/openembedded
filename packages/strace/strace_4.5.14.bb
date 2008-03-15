DESCRIPTION = "strace is a system call tracing tool."
SECTION = "console/utils"
LICENSE = "GPL"
PR = "r5"

SRC_URI = "${SOURCEFORGE_MIRROR}/strace/strace-${PV}.tar.bz2 \
           file://glibc-2.5.patch;patch=1 \
           file://arm-eabi.patch;patch=1 \
           file://drop-ctl-proc.patch;patch=1 \
           file://sh-arch-update.patch;patch=1 \
           file://sh-syscall-update.patch;patch=1 \
           file://strace-fix-arm-bad-syscall.patch;patch=1 \
           file://strace-undef-syscall.patch;patch=1 \
          "

SRC_URI_avr32 = "${SOURCEFORGE_MIRROR}/strace/strace-${PV}.tar.bz2 \
           file://strace-4.5.14-avr32.patch;patch=1 \
           file://strace-4.5.14-add-syscalls-up-to-sysvipc.patch;patch=1 \  
          "

inherit autotools

export INCLUDES = "-I. -I./linux"
