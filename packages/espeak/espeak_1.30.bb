#! /bin/sh
#
# Copyright Matthias Hentges <devel@hentges.net> (c) 2008
# License: MIT (see http://www.opensource.org/licenses/mit-license.php 
#               for a copy of the license)
#
# Filename: espeak_1.30.bb
# Date: 20080104 (YMD)

DESCRIPTION = "eSpeak is a compact open source software speech synthesizer"
SECTION = "base"
LICENSE = "GPL"

DEPENDS = "portaudio-v19"

######################################################################################

PR = "r2"

SRC_URI = "${SOURCEFORGE_MIRROR}/espeak/espeak-${PV}-source.zip"

S = "${WORKDIR}/${PN}-${PV}-source"

FILES_${PN} += " /usr/share/espeak-data/ "

do_configure() {
	# espeak supports portaudio in APIs V18 and V19
	cp ${S}/src/portaudio19.h ${S}/src/portaudio.h 
}

do_compile() {
	cd src
	oe_runmake
}

do_install() {
        install -d ${D}${bindir}
	install -d ${D}${libdir}
        install -d ${D}${includedir}
	install -d ${D}/usr/share/espeak-data
	
	install -m 0755 ${S}/src/espeak ${D}${bindir}
	oe_libinstall -so -C src libespeak ${D}${libdir}
	
	cp -prf ${S}/espeak-data/* ${D}/usr/share/espeak-data
}

do_stage() {
	install -d ${STAGING_INCDIR}/espeak
	install -m 0644 ${S}/src/speak_lib.h ${STAGING_INCDIR}/espeak/
        oe_libinstall -so -C src libespeak ${STAGING_LIBDIR}
}
