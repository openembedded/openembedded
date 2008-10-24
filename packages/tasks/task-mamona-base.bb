DESCRIPTION = "task mamona base"
LICENSE = "MIT"
PR = "r2"
ALLOW_EMPTY = "1"

PACKAGES = "${PN}"

RDEPENDS = "\
  apt \
  base-files \
  base-passwd \
  bash | bash-noemu \
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
  zlib \
"
