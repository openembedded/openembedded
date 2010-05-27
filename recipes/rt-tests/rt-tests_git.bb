DESCRIPTION = "Real-time tests, such as cyclictest, for real-time linux PREEMPT RT kernels"
HOMEPAGE = "http://rt.wiki.kernel.org/index.php/Cyclictest"
LICENSE = "GPL"
PR = "r0"

SRCREV = "42ab9e7cd259fae674dc2b2aa2962caaf8f09409"

PV = "0.51+${PR}+gitr${SRCREV}"

SRC_URI = "git://git.kernel.org/pub/scm/linux/kernel/git/tglx/rt-tests;protocol=git"

S = "${WORKDIR}/git"

# Limit to cyclictest only for non-real-time kernels.
# EXTRA_OEMAKE = "cyclictest"

TARGET_CC_ARCH += "${LDFLAGS}"

do_install() {
  install -d ${D}${bindir}
  # any file that is executable by user and/or group
  for binary in `find . -perm /u+x,g+x -type f`
  do
    install -m 0755 $binary ${D}${bindir}
  done
}
