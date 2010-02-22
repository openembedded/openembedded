DESCRIPTION = "A set of command line tools useful for debugging"
SECTION = "console"
LICENSE = "MIT"
PV = "1.0"
PR = "r12"

inherit task

PACKAGES += "${PN}-debug"

RDEPENDS_${PN} = "\
  dosfstools \
  htop \
  iptables \
  lsof \
  mbuffer \
  mdbus2 \
  mtd-utils \
  mterm2 \
  nano \
  nfs-utils-client \
  powertop \
  screen \
  serial-forward \
  socat \
  sysstat \
  tcpdump \
"

RDEPENDS_${PN}-debug = "\
  evtest \
  devmem2 \
  i2c-tools \
  ltrace \
  procps \
  pxaregs \
  s3c24xx-gpio \
  s3c64xx-gpio \
  strace \
"
