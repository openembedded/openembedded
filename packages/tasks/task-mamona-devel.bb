DESCRIPTION = "Necessary packages for development"
LICENSE = "MIT"
PR = "r1"
ALLOW_EMPTY = "1"

PACKAGES = "${PN}"

RDEPENDS = "\
  automake \
  bison \
  fakeroot \
  flex \
  gcc \
  gcc-symlinks \
  g++ \
  g++-symlinks \
  gdb \
  gettext \
  groff \
  libc6-dev \
  libstdc++-dev \
  make \
  cvs \
  subversion \
  pkgconfig \
"