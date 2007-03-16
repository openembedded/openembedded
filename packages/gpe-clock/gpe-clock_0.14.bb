require gpe-clock.inc

PR = "r1"

SRC_URI = "${GPE_MIRROR}/${PN}-${PV}.tar.gz \
	   file://default-time-24hrs.patch;patch=1"
