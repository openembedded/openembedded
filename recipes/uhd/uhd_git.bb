require recipes/uhd/uhd.inc

PR = "${INC_PR}.0"

SRC_URI = "git://ettus.sourcerepo.com/ettus/uhd.git;protocol=git"
S = "${WORKDIR}/git/host"

SRCREV = "816a07bee54e998e4fb25beeb44b9ac3888189bf"
