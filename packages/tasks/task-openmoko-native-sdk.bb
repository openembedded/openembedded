DESCRIPTION = "OpenMoko: Native SDK"
SECTION = "openmoko/base"
LICENSE = "MIT"
PR = "r58"

ALLOW_EMPTY = "1"
PACKAGE_ARCH = "all"

RDEPENDS_task-openmoko-native-sdk = "\
  binutils \
  binutils-symlinks \
  gcc \
  gcc-symlinks \
  cpp \
  cpp-symlinks \
  cvs \
  libc6-dev \
  libgcc-dev \
  glibc-utils \
  ldd \
  g++ \
  g++-symlinks \
  libstdc++-dev \
  \
  make \
  flex \
  flex-dev \
  bison \
  gawk \
  grep \
  sed \
  automake \
  autoconf \
  patch \
  patchutils \
  diffstat \
  diffutils \
  libtool \
  pkgconfig \
  \
  xoo \
"
