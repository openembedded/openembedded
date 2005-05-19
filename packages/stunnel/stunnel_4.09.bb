include stunnel.inc

SRC_URI = "http://www.stunnel.org/download/stunnel/src/stunnel-${PV}.tar.gz \
	   file://configure.patch;patch=1 \
	   file://automake.patch;patch=1 \
	   file://init \
	   file://stunnel.conf"
