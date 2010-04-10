# sox OE build file
# Copyright (C) 2005, Advanced Micro Devices, Inc.  All Rights Reserved
# Released under the MIT license (see packages/COPYING)

DESCRIPTION="SoX is the Swiss Army knife of sound processing tools. \
It converts audio files among various standard audio file formats \
and can apply different effects and filters to the audio data." 
LICENSE="GPL"
HOMEPAGE="http://sox.sourceforge.net"

SRC_URI="${SOURCEFORGE_MIRROR}/sox/sox-${PV}.tar.gz; \
	file://uclibc-fixes.patch;patch=1"

inherit autotools

do_install() {
	make bindir="${D}${bindir}" libdir="${D}${libdir}" mandir="${D}/${mandir}" includedir="${D}${includedir}" install
	rm ${D}${bindir}/rec
	ln -s /usr/bin/play ${D}${bindir}/rec
}

SRC_URI[md5sum] = "53a3ebe3da0f5845770fd99e2ff0a965"
SRC_URI[sha256sum] = "9efdc359ccc15af51edc33ead837f0820d353165c633cbe8c86f65ff0d3be30c"
