DESCRIPTION = "Mamona SDK - Packages for compilation and debug"
LICENSE = "MIT"
ALLOW_EMPTY = "1"

PACKAGES = "${PN}"

RDEPENDS = "\
  task-mamona \
  automake \
  bison \
  fakeroot \
  flex \
  gdb \
  gettext \
  groff \
  libc6-dev \
  libstdc++-dev \
  make \
  cvs \
  subversion \
  pkgconfig \
  diffutils \
"
