DESCRIPTION = "eSpeak is a compact open source software speech synthesizer"
SECTION = "base"
LICENSE = "GPL"
DEPENDS = "portaudio-v19"

PR = "r0"

SRC_URI = "${SOURCEFORGE_MIRROR}/espeak/espeak-${PV}-source.zip"

S = "${WORKDIR}/${PN}-${PV}-source"

FILES_${PN} += "${datadir}/espeak-data"

do_configure() {
	# "speak" binary, a TTS engine, uses portaudio in either APIs V18 or V19
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
        install -d ${D}${datadir}/espeak-data

        # we do not ship "speak" binary though.
        install -m 0755 ${S}/src/espeak ${D}${bindir}
        install -m 0644 ${S}/src/speak_lib.h ${D}${includedir}
        oe_libinstall -so -C src libespeak ${D}${libdir}

        cp -prf ${S}/espeak-data/* ${D}${datadir}/espeak-data
}

do_stage() {
        install -d ${STAGING_INCDIR}/espeak
        install -m 0644 ${S}/src/speak_lib.h ${STAGING_INCDIR}/espeak/
        oe_libinstall -so -C src libespeak ${STAGING_LIBDIR}
}
