# live555 OE build file
# Copyright (C) 2005, Koninklijke Philips Electronics NV.  All Rights Reserved
# Released under the MIT license (see packages/COPYING)

DESCRIPTION = "LIVE555 Streaming Media libraries"
HOMEPAGE = "http://live.com/"
LICENSE = "LGPL"
SECTION = "devel"

SRC_URI = "http://downloads.videolan.org/pub/videolan/vlc/0.8.5/contrib/live.2005.10.05.tar.gz \
           file://config.linux-cross"

S = "${WORKDIR}/live"

do_configure() {
	cp ${WORKDIR}/config.linux-cross .
	./genMakefiles linux-cross
}

do_compile() {
	make
}


SRC_URI[md5sum] = "6f15406664ef31172c68d46567569bb8"
SRC_URI[sha256sum] = "9532b981c9b8974ceedd3d25a8f9a0e167a92c9da0dece47f34a4ec34e34b1cf"
