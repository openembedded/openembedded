DESCRIPTION = "Java compiler adhering to language and VM specifications"
HOMEPAGE = "http://jikes.sourceforge.net/"
PRIORITY = "optional"
SECTION = "devel"
LICENSE = "IBM"
PR = "r1"

RDEPENDS = "classpath"

SRC_URI = "${SOURCEFORGE_MIRROR}/jikes/jikes-${PV}.tar.bz2"

inherit autotools update-alternatives

EXTRA_OECONF = "--disable-fp-emulation --enable-source15"

# configure script incorrectly defines these when cross compiling for ARM
CXXFLAGS_append_arm += "-UHAVE_64BIT_TYPES -DWORDS_BIGENDIAN=1"

do_install() {
	oe_runmake 'DESTDIR=${D}' install
    ln -s ${bindir}/jikes ${D}${bindir}/javac.jikes
}

PROVIDES = "virtual/javac"
ALTERNATIVE_NAME = "javac"
ALTERNATIVE_LINK = "/usr/bin/javac"
ALTERNATIVE_PATH = "${bindir}/javac.jikes"
