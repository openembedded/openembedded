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

SRC_URI[md5sum] = "29ae9cac05423cf6a49f66eeb1a79eb6"
SRC_URI[sha256sum] = "67be087c24af9d2a380b29d6e90b7187b337a0c484c31438a0d38ff429c71100"
