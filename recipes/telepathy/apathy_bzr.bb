DESCRIPTION = "Apathy is a free software communications client designed for mobile platforms"
HOMEPAGE = "http://www.openapathy.org/"
AUTHOR = "Mike Sheldon <mike@mikeasoft.com>"
LICENSE = "GPL3"

PV = "0.0.1+${SRCREV}"
PR = "r0"

inherit distutils

SRC_URI = "bzr://code.launchpad.net/apathy;proto=https"
S = "${WORKDIR}/${PN}"

FILES_${PN} += "${datadir}/${PN}"
