DESCRIPTION = "ALSA Plugins"
HOMEPAGE = "http://www.alsa-project.org"
SECTION = "multimedia/alsa/plugins"
LICENSE = "GPL"
DEPENDS = "alsa-lib pulseaudio ffmpeg"
PR = "r1"

SRC_URI = "ftp://ftp.alsa-project.org/pub/plugins/alsa-plugins-${PV}.tar.bz2"
SRC_URI[md5sum] = "a671f8102366c5b388133e948e1c85cb"
SRC_URI[sha256sum] = "5c1b2791ad33ef01f0f4f040004c931310da05e45aaa8d4146024c586f2b3183"

inherit autotools

CFLAGS += "-lavutil"

PACKAGES_DYNAMIC = "libasound-module*"

python populate_packages_prepend() {
        plugindir = bb.data.expand('${libdir}/alsa-lib/', d)
        do_split_packages(d, plugindir, '^libasound_module_(.*)\.so$', 'libasound-module-%s', 'Alsa plugin for %s', extra_depends='' )
}

FILES_${PN}-dev += "${libdir}/alsa-lib/libasound*.a ${libdir}/alsa-lib/libasound*.la"
FILES_${PN}-dbg += "${libdir}/alsa-lib/.debug"

