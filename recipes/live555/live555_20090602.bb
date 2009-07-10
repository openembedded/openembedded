# live555 OE build file
# Copyright (C) 2005, Koninklijke Philips Electronics NV.  All Rights Reserved
# Released under the MIT license (see packages/COPYING)

DESCRIPTION = "LIVE555 Streaming Media libraries"
HOMEPAGE = "http://live.com/"
LICENSE = "LGPL"
SECTION = "devel"

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
	cp ${S}/*/*.a ${D}${libdir}
}

do_stage () {
	cp -a ${D}${includedir}/* ${STAGING_INCDIR}
	cp -a ${D}${libdir}/* ${STAGING_LIBDIR}
}

