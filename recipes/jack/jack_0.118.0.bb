DESCRIPTION = "JACK is a low-latency audio server. It can \
connect a number of different applications to an audio \
device, as well as allowing them to share audio between \
themselves."
SECTION = "libs/multimedia"
PRIORITY = "optional"
LICENSE = "GPLv2 LGPLv2.1"

DEPENDS = "alsa-lib"

PR = "r2"

# Original has disappeared. Use Angstrom mirror for now.
#SRC_URI = "http://jackaudio.org/downloads/jack-audio-connection-kit-${PV}.tar.gz"
SRC_URI = "http://www.angstrom-distribution.org/unstable/sources/jack-audio-connection-kit-${PV}.tar.gz"
SRC_URI[md5sum] = "d58e29a55f285d54e75134cec8e02a10"
SRC_URI[sha256sum] = "6aadf38ca98104772fd675bba7adecf72d2a600e17cccfc5d1f7c50f19b722c2"

# This is not omap3 specific, but there is a strong correlation between using twl4030 and using omap3
SRC_URI_append_omap3 = " file://jack_fix_TWL4030_alsa_capture.patch"

S = "${WORKDIR}/jack-audio-connection-kit-${PV}"

inherit autotools

EXTRA_OECONF = "--enable-timestamps --disable-capabilities --disable-oldtrans \
		--disable-portaudio --disable-coreaudio --enable-oss --enable-alsa"

EXTRA_OEMAKE = 'transform="s,^,,"'
LDFLAGS_append = " -ldl -L${STAGING_LIBDIR}"

PACKAGES =+ "libjack jack-server jack-examples"

# Arch specific patch
PACKAGE_ARCH_omap3 = "${MACHINE_ARCH}"

FILES_libjack = "${libdir}/*.so.* ${libdir}/jack/*.so"
FILES_jack-server = "${bindir}/jackd"
FILES_jack-examples = "${bindir}/*"
FILES_${PN}-doc += " ${datadir}/jack-audio-connection-kit/reference/html/* "

