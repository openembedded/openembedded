DESCRIPTION = "ALSA Plugins"
HOMEPAGE = "http://www.alsa-project.org"
SECTION = "multimedia/alsa/plugins"
LICENSE = "GPL"
DEPENDS = "alsa-lib pulseaudio ffmpeg"
PR = "r1"

SRC_URI = "ftp://ftp.alsa-project.org/pub/plugins/alsa-plugins-${PV}.tar.bz2"

inherit autotools

CFLAGS += "-lavutil"

PACKAGES_DYNAMIC = "libasound-module*"

python populate_packages_prepend() {
        plugindir = bb.data.expand('${libdir}/alsa-lib/', d)
        do_split_packages(d, plugindir, '^libasound_module_(.*)\.so$', 'libasound-module-%s', 'Alsa plugin for %s', extra_depends='' )
}

FILES_${PN}-dev += "${libdir}/alsa-lib/libasound*.a ${libdir}/alsa-lib/libasound*.la"
FILES_${PN}-dbg += "${libdir}/alsa-lib/.debug"

SRC_URI[md5sum] = "819c4f21e3e913eacefd32993a8fbed7"
SRC_URI[sha256sum] = "210ceedcb84bf3030e9f362d55b734312632ce72e348bd758536ec62a37aac97"
