DESCRIPTION = "Pulseaudio is a sound server for Linux and Unix-like operating systems."
HOMEPAGE = "http://www.pulseaudio.org"
AUTHOR = "Lennart Poettering"
SECTION = "libs"
LICENSE = "LGPL"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"
DEPENDS = "liboil libsamplerate0 libsndfile1 libtool"
# optional
DEPENDS += "alsa-lib"

SRC_URI = "http://0pointer.de/lennart/projects/pulseaudio/pulseaudio-${PV}.tar.gz"

inherit autotools

EXTRA_OECONF = "--disable-lynx --without-x --without-glib --without-jack --with-alsa --with-oss"

PARALLEL_MAKE = ""

PACKAGES_DYNAMIC = "pulseaudio-module-**"

python populate_packages_prepend() {
        bb.data.setVar('PKG_pulseaudio', 'pulseaudio', d)

        plugindir = bb.data.expand('${libdir}/pulse-0.9/modules/', d)
        do_split_packages(d, plugindir, '^module-(.*)\.so$', 'pulseaudio-module-%s', 'PulseAudio module for %s', extra_depends='' )
}
