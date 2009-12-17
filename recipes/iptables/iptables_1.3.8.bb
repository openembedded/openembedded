require iptables.inc
PR = "${INC_PR}.0"

SRC_URI += "\
  file://getsockopt-failed.patch;patch=1 \
  file://iptables-use-s6_addr32.patch;patch=1 \
  file://cross-iptables.diff;patch=1 \
"

