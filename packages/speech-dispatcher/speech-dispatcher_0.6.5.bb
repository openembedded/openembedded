DESCRIPTION = "Speech Dispatcher is a high-level device independent layer \
for speech synthesis through a simple, stable and well documented interface."
HOMEPAGE = "http://www.freebsoft.org/speechd/"
LICENSE = "GPLv2"
DEPENDS = "flite libdotconf glib-2.0"
RPROVIDES_${PN} += "speechd"

PR = "r5"

inherit autotools update-rc.d

SRC_URI = "http://www.freebsoft.org/pub/projects/speechd/${PN}-${PV}.tar.gz \
	   file://speech-dispatcher.init \
           file://srcMakefile.am.patch;patch=1 \
	   file://configSpeechd.conf.in_00.patch;patch=1"

LEAD_SONAME = "libspeechd.so"
EXTRA_OECONF = " --with-espeak=yes --with-flite=no --with-ibmtts=no --with-nas=no --with-alsa=yes --with-pulse=yes "

INITSCRIPT_NAME = "speech-dispatcher"
INITSCRIPT_PARAMS = "defaults 45"

do_install() {
        install -d ${D}${bindir}
        install -d ${D}${includedir}
        install -d ${D}${libdir}/${PN}-modules
	install -d ${D}${sysconfdir}	
	install -d ${D}${sysconfdir}/init.d
	install -d ${D}${sysconfdir}/speech-dispatcher
	install -d ${D}${sysconfdir}/speech-dispatcher/modules

        oe_libinstall -so -C src/audio libsdaudio ${D}${libdir}
        oe_libinstall -so -C src/c/api libspeechd ${D}${libdir}
        
        install -m 0644 ${S}/src/c/api/libspeechd.h    ${D}${includedir}
        install -m 0755 ${S}/src/c/clients/say/.libs/spd-say ${D}${bindir}
        install -m 0755 ${S}/src/c/clients/spdsend/spdsend ${D}${bindir}
        install -m 0755 ${S}/src/server/.libs/speech-dispatcher  ${D}${bindir}
        install -m 0755 ${S}/src/modules/.libs/sd_*   ${D}${libdir}/${PN}-modules/
	
	install -m 0644 ${S}/config/speechd.conf ${D}${sysconfdir}/speech-dispatcher
	install -m 0644 ${S}/config/modules/*.conf ${D}${sysconfdir}/speech-dispatcher/modules
	install -m 0755 ${WORKDIR}/speech-dispatcher.init ${D}${sysconfdir}/init.d/speech-dispatcher
}

do_stage() {
        install -m 0644 ${S}/src/c/api/libspeechd.h ${STAGING_INCDIR}
        oe_libinstall -so -C src/c/api libspeechd ${STAGING_LIBDIR}
}

FILES_${PN} += "${libdir}/${PN}-modules/*" 
