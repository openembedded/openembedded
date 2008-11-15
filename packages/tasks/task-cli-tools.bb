DESCRIPTION = "A set of command line tools"
SECTION = "console"
LICENSE = "MIT"
PV = "1.0"
PR = "r1"

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
  sysstat \
  tcpdump \
"

RDEPENDS_${PN}_append_om-gta01 = "\
  s3c24xx-gpio \
"
RDEPENDS_${PN}_append_om-gta02 = "\
  s3c24xx-gpio \
"

RDEPENDS_${PN}-python = "\
  mickeydbus \
  mickeyterm \
"
