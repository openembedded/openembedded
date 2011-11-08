require recipes/uhd/uhd.inc

PR = "${INC_PR}.9"

SRC_URI = "git://ettus.sourcerepo.com/ettus/uhd.git;protocol=git"
S = "${WORKDIR}/git/host"

SRCREV = "f8d66fcfb14062283cdb0d0cbe4f77e2964ceb82"
