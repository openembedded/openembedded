
require midpath_${PV}.bb

DEPENDS = "pulseaudio"
RDEPENDS = "pulseaudio"

do_configure() {
	cd ${S}/native/pulseaudio
	sed -i -e "s|\-I/usr/include/classpath|\-I${STAGING_INCDIR}/classpath-minimal|" Makefile
	cd ${S}/resources-embedded/com/sun/midp/configuration
	sed -i -e "s|sound.backend:NULL|sound.backend:PulseAudio|" configuration.cfg
}

do_compile() {

# Build the PulseAudio native part
cd ${S}/native/pulseaudio
make || exit 1

}

do_install() {
	install -d ${D}${libdir}
	install -m 0644 ${S}/native/pulseaudio/libmidpathpulse.so ${D}${libdir}
	install -d ${D}${datadir}/java/resources-embedded/com/sun/midp/configuration
	install -m 0644 resources-embedded/com/sun/midp/configuration/configuration.cfg ${D}${datadir}/java/resources-embedded/com/sun/midp/configuration/
}

do_stage() {
	:
}
	
PACKAGES = "${PN}"

FILES_${PN}  = "${libdir}/libmidpathpulse.so \
                ${datadir}/java/resources-embedded/com/sun/midp/configuration/configuration.cfg \
	       "

CONFFILES_${PN} = "${datadir}/java/resources-embedded/com/sun/midp/configuration/configuration.cfg"
