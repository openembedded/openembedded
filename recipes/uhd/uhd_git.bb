require recipes/uhd/uhd.inc

PR = "${INC_PR}.8"

SRC_URI = "git://ettus.sourcerepo.com/ettus/uhd.git;protocol=git"
S = "${WORKDIR}/git/host"

SRCREV = "26aacf3edc1331691827156903a65125532ea6a8"
