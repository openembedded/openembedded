include boost.inc
PR = "${INC_PR}.1"

SRC_URI = "\
  ${SOURCEFORGE_MIRROR}/boost/${BOOST_P}.tar.bz2 \
  file://linux-uclibc.patch;patch=1 \
  file://atomic_count_gcc_atomicity.patch;patch=1 \
  file://gcc43.patch;patch=1 \
  file://gcc41.patch;patch=1 \
"

