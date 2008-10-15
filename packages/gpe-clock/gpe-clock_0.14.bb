require gpe-clock.inc

FILE_PR = "r1"

SRC_URI = "${GPE_MIRROR}/${PN}-${PV}.tar.gz \
	   file://default-time-24hrs.patch;patch=1"
