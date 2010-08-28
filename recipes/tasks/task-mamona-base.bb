DESCRIPTION = "task mamona base"
LICENSE = "MIT"
PR = "r5"
ALLOW_EMPTY = "1"

PACKAGES = "${PN}"

RDEPENDS_${PN} = "\
  apt \
  base-files \
  base-passwd \
  bash \
  bash-noemu \
  busybox \
  bzip2 \
  coreutils \
  dpkg \
  e2fsprogs \
  e2fsprogs-badblocks \
  util-linux-ng \
  file \
  gawk \
  gawk-common \
  initscripts \
  libgcc \
  libstdc++ \
  makedevs \
  ncurses \
  netbase \
  patch \
  perl \
  pkgconfig \
  procps \
  sed \
  sudo \
  sysvinit \
  sysvinit-inittab \
  tar \
  tinylogin \
  udev \
  update-alternatives-dpkg \
  update-rc.d \
  util-linux \
  util-linux-losetup \
  util-linux-swaponoff \
  util-linux-umount \
  util-linux-ng-blkid \
  zlib \
"
