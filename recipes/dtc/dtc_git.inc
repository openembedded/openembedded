SRC_URI = "git://www.jdl.com/software/dtc.git;protocol=git"
SRCREV = "73dca9ae0b9abe6924ba640164ecce9f8df69c5a"
PV = "1.2.0"
PR = "r1"
PR_append = "+gitr${SRCREV}"

DEFAULT_PREFERENCE = "-1"

S = "${WORKDIR}/git"
