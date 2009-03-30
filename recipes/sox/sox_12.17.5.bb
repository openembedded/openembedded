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
