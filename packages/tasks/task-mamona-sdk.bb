DESCRIPTION = "Mamona SDK - Packages for compilation and debug"
LICENSE = "MIT"
PR = "r2"
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
  binutils \
"