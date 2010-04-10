DESCRIPTION = "Real-time tests, such as cyclictest, for real-time linux PREEMPT RT kernels"
HOMEPAGE = "http://rt.wiki.kernel.org/index.php/Cyclictest"
LICENSE = "GPL"
PR = "r1"

SRC_URI = "http://www.kernel.org/pub/linux/kernel/people/tglx/rt-tests/rt-tests-${PV}.tar.bz2"

S = "${WORKDIR}/rt-tests"

TARGET_CC_ARCH += "${LDFLAGS}"

# Limit to cyclictest only for non-real-time kernels.
# EXTRA_OEMAKE = "cyclictest"

do_install() {
  install -d ${D}${bindir}
  # any file that is executable by user and/or group
  for binary in `find . -perm /u+x,g+x -type f`
  do
    install -m 0755 $binary ${D}${bindir}
  done
}

SRC_URI[md5sum] = "761c3e9fab16290c10ab9421182d16e7"
SRC_URI[sha256sum] = "48e5a43c03f42524dd91873d649a0b8a287debd727da993ab256dc4e839b0cee"
