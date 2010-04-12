require gpe-clock.inc

PR = "${INC_PR}.0"

SRC_URI = "${GPE_MIRROR}/${PN}-${PV}.tar.gz \
	   file://default-time-24hrs.patch;patch=1"

SRC_URI[md5sum] = "367d329ff8af75abcb7f214e9b669c9c"
SRC_URI[sha256sum] = "fb5790c58430e1ce9cfdccef117de4937c35a411894642aea622638519e5b764"
