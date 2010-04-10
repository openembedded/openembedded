include boost.inc
PR = "${INC_PR}.1"

SRC_URI = "\
  ${SOURCEFORGE_MIRROR}/boost/${BOOST_P}.tar.bz2 \
  file://linux-uclibc.patch;patch=1 \
  file://atomic_count_gcc_atomicity.patch;patch=1 \
  file://gcc43.patch;patch=1 \
  file://gcc41.patch;patch=1 \
"


SRC_URI[md5sum] = "2b999b2fb7798e1737d1fff8fac602ef"
SRC_URI[sha256sum] = "6232e93205acbc8c705f44f15977aae158550c99a384f41606cff26c16393be0"
