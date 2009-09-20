require tzcode-native.inc
SRC_URI = "\
  http://bent.latency.net/bent/darcs/zoneinfo-${PV}/src/tzcode${PV}.tar.gz \
  http://bent.latency.net/bent/darcs/zoneinfo-${PV}/src/tzdata${PV}.tar.gz \
"

PR = "${INC_PR}.0"
