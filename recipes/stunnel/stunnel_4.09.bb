require stunnel.inc

SRC_URI = "http://www.stunnel.org/download/stunnel/src/stunnel-${PV}.tar.gz \
	   file://configure.patch;patch=1 \
	   file://automake.patch;patch=1 \
	   file://init \
	   file://stunnel.conf"

SRC_URI[md5sum] = "2077669b04c36e4c0baa68348e8860a7"
SRC_URI[sha256sum] = "56004db651fe180ed23882c555607c8f2723a3e99734d462fe644e531a574271"
