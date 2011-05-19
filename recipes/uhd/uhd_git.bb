require recipes/uhd/uhd.inc

PR = "${INC_PR}.4"

SRC_URI = "git://ettus.sourcerepo.com/ettus/uhd.git;protocol=git"
S = "${WORKDIR}/git/host"

SRCREV = "0aff497dacc9cc4eba5d800cc46343da083cfdf1"
