DESCRIPTION = "task mamona base"
LICENSE = "MIT"
PR = "r1"
ALLOW_EMPTY = "1"

PACKAGES = "${PN}"

RDEPENDS = "\
  apt \
  base-files \
  base-passwd \
  bash \
  binutils \
  busybox \
  bzip2 \
  coreutils \
  dpkg \
  e2fsprogs \
  e2fsprogs-badblocks \
  e2fsprogs-blkid \
  e2fsprogs-uuidgen \
  file \
  gawk \
  gawk-common \
  libgcc \
  libstdc++ \
  zlib \
  ncurses \
  netbase \
  perl \
  perl-module-base \
  perl-module-carp \
  perl-module-exporter \
  perl-module-strict \
  perl-module-vars \
  perl-module-warnings \
  perl-module-warnings-register \
  procps \
  sed \
  sysvinit \
  sysvinit-inittab \
  tar \
  udev \
  update-alternatives-dpkg \
  update-rc.d \
  util-linux \
  util-linux-losetup \
  util-linux-swaponoff \
  util-linux-umount \
  pkgconfig \
  initscripts \
  makedevs \
  patch \
  tinylogin \
  sudo \
"
