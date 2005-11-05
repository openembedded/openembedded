DESCRIPTION = "JACK is a low-latency audio server. It can \
connect a number of different applications to an audio \
device, as well as allowing them to share audio between \
themselves."
SECTION = "libs/multimedia"
PRIORITY = "optional"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"
LICENSE = "GPL LGPL" 
PR = "r0"

SRC_URI = "${SOURCEFORGE_MIRROR}/jackit/jack-audio-connection-kit-${PV}.tar.gz"
S = "${WORKDIR}/jack-audio-connection-kit-${PV}"

inherit autotools pkgconfig

EXTRA_OECONF = "--enable-timestamps --disable-capabilities --disable-oldtrans \
		--disable-portaudio --disable-coreaudio --enable-oss --enable-alsa"

EXTRA_OEMAKE = 'transform="s,^,,"'

do_configure() {
	gnu-configize
	oe_runconf
}

do_install_append() {
	install -d ${D}${docdir}
	mv -f ${D}${datadir}/jack-audio-connection-kit ${D}${docdir}/
}

PACKAGES = "libjack jack-server jack-examples jack-doc jack-dev"
FILES_libjack = "${libdir}/*.so.* ${libdir}/jack/*.so"
FILES_jack-server = "${bindir}/jackd"
FILES_jack-examples = "${bindir}"
