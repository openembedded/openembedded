require stunnel.inc

SRC_URI = "http://www.the-little-red-haired-girl.org/pub/nylon/thirdparty/stunnel-${PV}.tar.gz \
	   file://configure.patch;patch=1 \
	   file://automake.patch;patch=1 \
	   file://init \
	   file://stunnel.conf"
