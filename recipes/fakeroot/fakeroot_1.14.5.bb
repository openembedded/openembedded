require fakeroot.inc
PE = "1"
PR = "${INC_PR}.0"

SRC_URI =+ "\
  http://snapshot.debian.org/archive/debian/20110301/pool/main/f/fakeroot/fakeroot_1.14.5.orig.tar.bz2 \
  file://quiet-getopt-check.patch \
"

SRC_URI[md5sum] = "659a1f3a36554abfc2a3eaad2fdc0604"
SRC_URI[sha256] = "b035c834944bf9482027f48c388de8492e96609825265ac03f05408d0b3aae68"
