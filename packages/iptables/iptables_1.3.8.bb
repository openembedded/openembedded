require iptables.inc
FILE_PR = "r4"

SRC_URI += "\
  file://getsockopt-failed.patch;patch=1 \
  file://iptables-use-s6_addr32.patch;patch=1 \
"

