require recipes/uhd/uhd.inc

PR = "${INC_PR}.5"

SRC_URI = "git://ettus.sourcerepo.com/ettus/uhd.git;protocol=git"
S = "${WORKDIR}/git/host"

SRCREV = "fc349d30507620baca935e75e68a9554b40d427c"
