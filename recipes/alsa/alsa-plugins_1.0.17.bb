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

SRC_URI[md5sum] = "f37d0b2b19dfbe215144941ab8bb6e49"
SRC_URI[sha256sum] = "35a7e1411ab7b34353136ecfbd2267201d37b671f48b946bf238a6d1f7fdf560"
