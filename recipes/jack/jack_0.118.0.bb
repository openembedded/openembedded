DESCRIPTION = "JACK is a low-latency audio server. It can \
connect a number of different applications to an audio \
device, as well as allowing them to share audio between \
themselves."
SECTION = "libs/multimedia"
PRIORITY = "optional"
LICENSE = "GPLv2 LGPLv2.1"

DEPENDS = "alsa-lib"

PR = "r3"

SVNPV = "${@'${PV}'.replace('.', '_')}"
SRCREV = "4084"
SRC_URI = "svn://subversion.jackaudio.org/jack/tags;module=RELEASE_${SVNPV};proto=http \
           file://remove-wrong-host-test.patch \
           "

# This is not omap3 specific, but there is a strong correlation between using twl4030 and using omap3
SRC_URI_append_omap3 = " file://jack_fix_TWL4030_alsa_capture.patch"

S = "${WORKDIR}/RELEASE_${SVNPV}"

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
