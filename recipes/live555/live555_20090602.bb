# live555 OE build file
# Copyright (C) 2005, Koninklijke Philips Electronics NV.  All Rights Reserved
# Released under the MIT license (see packages/COPYING)

DESCRIPTION = "LIVE555 Streaming Media libraries"
HOMEPAGE = "http://live.com/"
LICENSE = "LGPL"
SECTION = "devel"

PR = "r3"

SRC_URI = "http://www.live555.com/liveMedia/public/live.2009.06.02.tar.gz \
           file://config.linux-cross"

S = "${WORKDIR}/live"

do_configure() {
	cp ${WORKDIR}/config.linux-cross .
	./genMakefiles linux-cross
}

do_compile() {
	make
}

do_install() {
	install -d ${D}${includedir}/BasicUsageEnvironment
	install -d ${D}${includedir}/groupsock
	install -d ${D}${includedir}/liveMedia
	install -d ${D}${includedir}/UsageEnvironment
	install -d ${D}${libdir}
	cp -a ${S}/BasicUsageEnvironment/include/*.hh ${D}${includedir}/BasicUsageEnvironment/
	cp -a ${S}/groupsock/include/*.h ${D}${includedir}/groupsock/
	cp -a ${S}/groupsock/include/*.hh ${D}${includedir}/groupsock/
	cp -a ${S}/liveMedia/include/*.hh ${D}${includedir}/liveMedia/
	cp -a ${S}/UsageEnvironment/include/*.hh ${D}${includedir}/UsageEnvironment/
	# Find all the headers
	for i in $(find . -name "*.hh") $(find . -name "*.h") ; do
		install ${i} ${D}${includedir}
	done
	cp ${S}/*/*.a ${D}${libdir}
}

SRC_URI[md5sum] = "088f848b64cef1d54034bc24cfa3c156"
SRC_URI[sha256sum] = "66c54241bfcc7ea42fe40e1c93739be79a3c065390c4163c0f2647ac45c24758"
