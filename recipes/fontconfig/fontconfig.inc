DESCRIPTION = "A library for configuring and customizing font access."
SECTION = "libs"
LICENSE = "BSD"
DEPENDS = "expat freetype freetype-native zlib"

PR = "r1"
# Work around past breakage in debian.bbclass
RPROVIDES_fontconfig-utils = "libfontconfig-utils"
RREPLACES_fontconfig-utils = "libfontconfig-utils"
RCONFLICTS_fontconfig-utils = "libfontconfig-utils"
DEBIAN_NOAUTONAME_fontconfig-utils = "1"

SRC_URI = "http://www.freedesktop.org/software/fontconfig/release/${BPN}-${PV}.tar.gz \
           file://01fc-cache"

inherit autotools pkgconfig

export HASDOCBOOK="no"

EXTRA_OECONF = " --disable-docs --with-cache-dir=/var/lib/fontconfig"
EXTRA_OEMAKE = "FC_LANG=fc-lang FC_GLYPHNAME=fc-glyphname"

# The tarball has some of the patched files as read only, which
# patch doesn't like at all

fontconfig_do_unpack() {
       chmod -R u+rw ${S}
}

python do_unpack () {
       bb.build.exec_func('base_do_unpack', d)
       bb.build.exec_func('fontconfig_do_unpack', d)
}

fontconfig-utils_do_install_prepend() {
        install -m 0755 ${WORKDIR}/01fc-cache ${D}${sysconfdir}/update-fonts-common.d/
}

PACKAGES =+ "fontconfig-utils-dbg fontconfig-utils "
FILES_fontconfig-utils-dbg += "${bindir}/*.dbg"
FILES_fontconfig-utils = "${bindir}/*"
