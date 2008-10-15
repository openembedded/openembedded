DESCRIPTION="SoX is the Swiss Army knife of sound processing tools. \
It converts audio files among various standard audio file formats \
and can apply different effects and filters to the audio data." 
HOMEPAGE = "http://sox.sourceforge.net"
SECTION = "audio"
LICENSE = "GPL"
PR = "r0"

SRC_URI = "${SOURCEFORGE_MIRROR}/sox/sox-${PV}.tar.gz \
         file://src-Makefile.am.patch;patch=1"

inherit autotools

do_install() {
	make bindir="${D}${bindir}" libdir="${D}${libdir}" mandir="${D}/${mandir}" includedir="${D}${includedir}" install
	rm ${D}${bindir}/rec
	ln -s /usr/bin/play ${D}${bindir}/rec
}
