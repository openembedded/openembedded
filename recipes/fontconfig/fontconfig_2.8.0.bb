DESCRIPTION = "A library for configuring and customizing font access."
SECTION = "libs"
LICENSE = "BSD"
DEPENDS = "expat freetype zlib"

# Work around past breakage in debian.bbclass
RPROVIDES_fontconfig-utils = "libfontconfig-utils"
RCONFLICTS_fontconfig-utils = "libfontconfig-utils"

SRC_URI = "http://fontconfig.org/release/fontconfig-${PV}.tar.gz;name=fontconfig"
SRC_URI[fontconfig.md5sum] = "77e15a92006ddc2adbb06f840d591c0e"
SRC_URI[fontconfig.sha256sum] = "fa2a1c6eea654d9fce7a4b1220f10c99cdec848dccaf1625c01f076b31382335"

S = "${WORKDIR}/fontconfig-${PV}"

inherit autotools pkgconfig

EXTRA_OECONF = " --disable-docs --with-arch=${HOST_ARCH} --with-cache-dir=/var/lib/fontconfig"
EXTRA_OEMAKE = "FC_LANG=fc-lang FC_GLYPHNAME=fc-glyphname"

export HASDOCBOOK="no"
BUILD_CFLAGS += " -I${STAGING_INCDIR}/freetype2"
PARALLEL_MAKE = ""

do_configure_append () {
        sed -i 's|LDFLAGS =.*|LDFLAGS =|' fc-case/Makefile
        sed -i 's|LDFLAGS =.*|LDFLAGS =|' fc-glyphname/Makefile
        sed -i 's|LDFLAGS =.*|LDFLAGS =|' fc-lang/Makefile
        sed -i 's|LDFLAGS =.*|LDFLAGS =|' fc-arch/Makefile
        sed -i 's|CFLAGS =.*|CFLAGS =${BUILD_CFLAGS}|' fc-case/Makefile
        sed -i 's|CFLAGS =.*|CFLAGS =${BUILD_CFLAGS}|' fc-glyphname/Makefile
        sed -i 's|CFLAGS =.*|CFLAGS =${BUILD_CFLAGS}|' fc-lang/Makefile
        sed -i 's|CFLAGS =.*|CFLAGS =${BUILD_CFLAGS}|' fc-arch/Makefile
        sed -i 's|CPPFLAGS =.*|CPPFLAGS =${BUILD_CPPFLAGS}|' fc-case/Makefile
        sed -i 's|CPPFLAGS =.*|CPPFLAGS =${BUILD_CPPFLAGS}|' fc-glyphname/Makefile
        sed -i 's|CPPFLAGS =.*|CPPFLAGS =${BUILD_CPPFLAGS}|' fc-lang/Makefile
        sed -i 's|CPPFLAGS =.*|CPPFLAGS =${BUILD_CPPFLAGS}|' fc-arch/Makefile
        sed -i 's|CXXFLAGS =.*|CFLAGS =${BUILD_CXXFLAGS}|' fc-case/Makefile
        sed -i 's|CXXFLAGS =.*|CFLAGS =${BUILD_CXXFLAGS}|' fc-glyphname/Makefile
        sed -i 's|CXXFLAGS =.*|CFLAGS =${BUILD_CXXFLAGS}|' fc-lang/Makefile
        sed -i 's|CXXFLAGS =.*|CFLAGS =${BUILD_CXXFLAGS}|' fc-arch/Makefile
}

# The tarball has some of the patched files as read only, which
# patch doesn't like at all

python do_unpack () {
       bb.build.exec_func('base_do_unpack', d)
       bb.build.exec_func('fontconfig_do_unpack', d)
}

fontconfig_do_unpack() {
       chmod -R u+rw ${S}
}

PACKAGES =+ "fontconfig-utils-dbg fontconfig-utils "

FILES_fontconfig-utils-dbg = "${bindir}/*.dbg"
FILES_fontconfig-utils = "${bindir}/*"

DEBIAN_NOAUTONAME_fontconfig-utils = "1"
RREPLACES_fontconfig-utils = "libfontconfig-utils"

