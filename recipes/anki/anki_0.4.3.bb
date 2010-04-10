require anki.inc

RDEPENDS += "libanki"
PR = "r2"

export PV := "${PV}"

SRC_URI += "file://no-need-for-pyqt-at-buildtime.patch;patch=1"
S = "${WORKDIR}/anki-${PV}"

SRC_URI[md5sum] = "90434860945de4c09d55cdb5dbe984fc"
SRC_URI[sha256sum] = "18a93fb46363ca34963fc2588cadf7415dd799dd647efa681859eb8b1b22f104"
