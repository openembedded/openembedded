require recipes/uhd/uhd.inc

PR = "${INC_PR}.3"

SRC_URI = "git://ettus.sourcerepo.com/ettus/uhd.git;protocol=git"
S = "${WORKDIR}/git/host"

SRCREV = "81e891f3f38259e7450b454933c979f2d8c93d65"
