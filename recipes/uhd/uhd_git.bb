require recipes/uhd/uhd.inc

PR = "${INC_PR}.7"

SRC_URI = "git://ettus.sourcerepo.com/ettus/uhd.git;protocol=git"
S = "${WORKDIR}/git/host"

SRCREV = "9d00821b51301412071944315e9d1555482b7e39"
