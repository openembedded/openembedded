require espeak.inc
inherit siteinfo

EXTRA_PHONEMES = '${@base_contains("SITEINFO_ENDIANESS", "be",  "espeak-data (= ${PV})", "", d)}'
RDEPENDS_${PN} = "portaudio-v19 ${EXTRA_PHONEMES}"

PR = "r0"

CXXFLAGS += "-DUSE_PORTAUDIO"
TARGET_CC_ARCH += "${LDFLAGS}"

FILES_${PN} += "${datadir}/espeak-data"

do_configure() {
       #  "speak" binary, a TTS engine, uses portaudio in either APIs V18 or V19, use V19
       cp "${S}/src/portaudio19.h" "${S}/src/portaudio.h"
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

	if [ "${SITEINFO_ENDIANESS}" = "be" ] ; then
		# the big-endian phon* files are provided by the package espeak-data
		rm -f ${S}/espeak-data/phon*
	fi

        cp -prf ${S}/espeak-data/* ${D}${datadir}/espeak-data
}

do_stage() {
        install -d ${STAGING_INCDIR}/espeak
        install -m 0644 ${S}/src/speak_lib.h ${STAGING_INCDIR}/espeak/
        oe_libinstall -so -C src libespeak ${STAGING_LIBDIR}
}
