require recipes/uhd/uhd.inc

PR = "${INC_PR}.6"

SRC_URI = "git://ettus.sourcerepo.com/ettus/uhd.git;protocol=git"
S = "${WORKDIR}/git/host"

SRCREV = "b20c9fc836a0f32666739dcd143692149eb66c68"
