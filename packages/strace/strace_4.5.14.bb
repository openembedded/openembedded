DESCRIPTION = "strace is a system call tracing tool."
SECTION = "console/utils"
LICENSE = "GPL"
PR = "r7"

SRC_URI = "${SOURCEFORGE_MIRROR}/strace/strace-${PV}.tar.bz2 \
           file://glibc-2.5.patch;patch=1 \
           file://arm-eabi.patch;patch=1 \
           file://drop-ctl-proc.patch;patch=1 \
           file://sh-arch-update.patch;patch=1 \
           file://sh-syscall-update.patch;patch=1 \
           file://strace-fix-arm-bad-syscall.patch;patch=1 \
           file://strace-undef-syscall.patch;patch=1 \
           file://strace-arm-no-cachectl.patch;patch=1 \
          "

# The strace-4.5.14-avr32.patch conflicts with some other patches.
# These patches are primarly for the ARM and SuperH, so we'll just
# not use them when building for the AVR32.
# The avr32 patch also includes the drop-ctl-proc.patch
# The AVR32 patches are from http://avr32linux.org/twiki/bin/view/Main/STrace
SRC_URI_avr32 = \
    "${SOURCEFORGE_MIRROR}/strace/strace-${PV}.tar.bz2 \
     file://strace-4.5.14-avr32.patch;patch=1 \
     file://strace-4.5.14-avr32-add-syscalls-up-to-sysvipc.patch;patch=1 \
    "

# Again, a different set of patches for MIPS. See http://bugs.openembedded.net/show_bug.cgi?id=2221
MIPS = "\
  ${SOURCEFORGE_MIRROR}/strace/strace-${PV}.tar.bz2 \
  file://glibc-2.5.patch;patch=1 \
  file://arm-eabi.patch;patch=1 \
  file://sh-arch-update.patch;patch=1 \
  file://sh-syscall-update.patch;patch=1 \
  file://strace-fix-arm-bad-syscall.patch;patch=1 \
  file://strace-undef-syscall.patch;patch=1 \
  file://strace-arm-no-cachectl.patch;patch=1 \
  file://mips-sigcontext.patch;patch=1 \
"
SRC_URI_mips = "${MIPS}"
SRC_URI_mipsel = "${MIPS}"

inherit autotools

export INCLUDES = "-I. -I./linux"
