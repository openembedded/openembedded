DESCRIPTION = "Pulseaudio is a sound server for Linux and Unix-like operating systems."
HOMEPAGE = "http://www.pulseaudio.org"
AUTHOR = "Lennart Poettering"
SECTION = "libs/multimedia"
LICENSE = "LGPL"
DEPENDS = "liboil libsamplerate0 libsndfile1 libtool"
# optional
DEPENDS += "alsa-lib"
PR = "r1"

SRC_URI = "http://0pointer.de/lennart/projects/pulseaudio/pulseaudio-${PV}.tar.gz"

inherit autotools

EXTRA_OECONF = "--disable-lynx --without-x --without-glib --without-jack --with-alsa --with-oss"

PARALLEL_MAKE = ""

LEAD_SONAME = "libpulse.so"
PACKAGES =+ "${PN}-conf ${PN}-bin"
PACKAGES_DYNAMIC = "pulseaudio-module-* pulseaudio-lib-*"
FILES_${PN}-conf = "${sysconfdir}"
FILES_${PN}-bin = "${bindir}"

python populate_packages_prepend() {
        #bb.data.setVar('PKG_pulseaudio', 'pulseaudio', d)

        plugindir = bb.data.expand('${libdir}/pulse-0.9/modules/', d)
        do_split_packages(d, plugindir, '^module-(.*)\.so$', 'pulseaudio-module-%s', 'PulseAudio module for %s', extra_depends='' )
	do_split_packages(d, plugindir, '^lib(.*)\.so$', 'pulseaudio-lib-%s', 'PulseAudio library for %s', extra_depends='' )
}
