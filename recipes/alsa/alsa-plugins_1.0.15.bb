DESCRIPTION = "ALSA Plugins"
HOMEPAGE = "http://www.alsa-project.org"
SECTION = "multimedia/alsa/plugins"
LICENSE = "GPL"
DEPENDS = "alsa-lib pulseaudio"
PR = "r0"

SRC_URI = "ftp://ftp.alsa-project.org/pub/plugins/alsa-plugins-${PV}.tar.bz2"

inherit autotools

PACKAGES_DYNAMIC = "libasound-module*"

python populate_packages_prepend() {
        plugindir = bb.data.expand('${libdir}/alsa-lib/', d)
        do_split_packages(d, plugindir, '^libasound_module_(.*)\.so$', 'libasound-module-%s', 'Alsa plugin for %s', extra_depends='' )
}

FILES_${PN}-dev += "${libdir}/alsa-lib/libasound*.a ${libdir}/alsa-lib/libasound*.la"
FILES_${PN}-dbg += "${libdir}/alsa-lib/.debug"

SRC_URI[md5sum] = "908c2dd7ec33bc8e1fcd5e92c7e5e125"
SRC_URI[sha256sum] = "3fec2349a94254c82dd568a8f4f8b8ef9735aee7dc56a5cf93e80f5938df9e95"
