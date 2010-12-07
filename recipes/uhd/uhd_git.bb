require recipes/uhd/uhd.inc

PR = "${INC_PR}.1"

SRC_URI = "git://ettus.sourcerepo.com/ettus/uhd.git;protocol=git"
S = "${WORKDIR}/git/host"

SRCREV = "a51fb2ed133f5550265d32e49d601d6d90e0e277"
