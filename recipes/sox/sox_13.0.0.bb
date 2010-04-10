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

SRC_URI[md5sum] = "0243d62895caee558b5294d5b78cfbcb"
SRC_URI[sha256sum] = "c66c52cfa42fe126592563c3d8974007a9858bd35d2c1136389a721eeebb9f8e"
