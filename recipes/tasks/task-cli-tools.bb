DESCRIPTION = "A set of command line tools"
SECTION = "console"
LICENSE = "MIT"
PV = "1.0"
PR = "r3"

inherit task

PACKAGES += "${PN}-python"

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
  s3c24xx-gpio \
"

RDEPENDS_${PN}-python = "\
  mickeydbus \
  mickeyterm \
"
