DESCRIPTION = "A set of command line tools"
SECTION = "console"
LICENSE = "MIT"
PV = "1.0"
PR = "r0"

inherit task

RDEPENDS_${PN} = "\
  dosfstools \
  htop \
  iptables \
  lsof \
  mickeydbus \
  mickeyterm \
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

