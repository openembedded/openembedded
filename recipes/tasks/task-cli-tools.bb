DESCRIPTION = "A set of command line tools useful for debugging"
SECTION = "console"
LICENSE = "MIT"
PV = "1.0"
PR = "r8"

inherit task

PACKAGES += "${PN}-debug"

RDEPENDS_${PN} = "\
  dosfstools \
  htop \
  iptables \
  lsof \
  mtd-utils \
  nano \
  nfs-utils-client \
  powertop \
  screen \
  socat \
  sysstat \
  tcpdump \
"

RDEPENDS_${PN}-debug = "\
  evtest \
  devmem2 \
  i2c-tools \
#  ltrace \
  procps \
  pxaregs \
  s3c24xx-gpio \
  s3c64xx-gpio \
  strace \
"
