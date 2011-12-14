require fakeroot.inc
PR = "${INC_PR}.0"

SRC_URI =+ "\
  ${DEBIAN_MIRROR}/main/f/fakeroot/fakeroot_${PV}.orig.tar.bz2 \
  file://quiet-getopt-check.patch \
"

SRC_URI[md5sum] = "659a1f3a36554abfc2a3eaad2fdc0604"
SRC_URI[sha256] = "b035c834944bf9482027f48c388de8492e96609825265ac03f05408d0b3aae68"
