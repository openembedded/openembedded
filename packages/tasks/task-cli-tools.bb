DESCRIPTION = "A set of command line tools, python tools-based tools, debug tools"
SECTION = "console"
LICENSE = "MIT"
PV = "1.0"
PR = "r4"

inherit task

PACKAGES += "${PN}-debug ${PN}-python"

RDEPENDS_${PN} = "\
  dosfstools \
  htop \
  iptables \
  lsof \
  mtd-utils \
  nano \
  powertop \
  screen \
  sysstat \
  tcpdump \
"

RDEPENDS_${PN}-debug = "\
  i2c-tools \
#  ltrace \
  procps \
  s3c24xx-gpio \
  s3c64xx-gpio \
  strace \
"

RDEPENDS_${PN}-python = "\
  mickeydbus \
  mickeyterm \
"
