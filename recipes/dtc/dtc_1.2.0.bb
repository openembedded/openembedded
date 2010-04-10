require dtc.inc

PR = "r0"

DEFAULT_PREFERENCE = "1"

SRC_URI = "http://www.jdl.com/software/dtc-v${PV}.tgz"

S = "${WORKDIR}/dtc-v${PV}"


SRC_URI[md5sum] = "0f1841de79abbff57691adc31d5f3525"
SRC_URI[sha256sum] = "dabbe5a77ffcffd906333589a75013e4b40113238b6b09f7f2ad280ba3bb6a1c"
