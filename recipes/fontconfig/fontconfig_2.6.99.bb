SECTION = "libs"
LICENSE = "BSD"
DESCRIPTION = "A library for configuring and customizing font access."
DEPENDS = "expat freetype zlib"

DEFAULT_PREFERENCE = "-1"
DEFAULT_PREFERENCE_angstrom = "1"

SRCREV = "96194cc3fa484837bf41598ff3f3d09b97c8dba4"
SRC_URI = "git://anongit.freedesktop.org/~behdad/fontconfig;protocol=git \
"

PR = "r2"
S = "${WORKDIR}/git"

PACKAGES =+ "fontconfig-utils-dbg fontconfig-utils "
FILES_fontconfig-utils-dbg = "${bindir}/*.dbg"
FILES_fontconfig-utils = "${bindir}/*"

# Work around past breakage in debian.bbclass
RPROVIDES_fontconfig-utils = "libfontconfig-utils"
RREPLACES_fontconfig-utils = "libfontconfig-utils"
RCONFLICTS_fontconfig-utils = "libfontconfig-utils"
DEBIAN_NOAUTONAME_fontconfig-utils = "1"

PARALLEL_MAKE = ""

inherit autotools

export HASDOCBOOK="no"

EXTRA_OECONF = " --disable-docs --with-arch=${HOST_ARCH} --with-cache-dir=/var/lib/fontconfig"
EXTRA_OEMAKE = "FC_LANG=fc-lang FC_GLYPHNAME=fc-glyphname"

BUILD_CFLAGS += " -I${STAGING_INCDIR}/freetype2"

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

do_compile_append() {
	sed -i -e s:${STAGING_LIBDIR}:\$\{libdir\}:g fontconfig.pc
}

do_install () {
	autotools_do_install
}

