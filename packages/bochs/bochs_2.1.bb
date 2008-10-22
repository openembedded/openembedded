DESCRIPTION = "An x86 Emulator based on SDL."
HOMEPAGE = "http://bochs.sf.net"
LICENSE = "GPL"
PR = "r1"

# needs a patch for recent g++
BROKEN = "1"

APPIMAGE = "doc/docbook/images/dlxlinux-in-linux.png"

SRC_URI = "${SOURCEFORGE_MIRROR}/bochs/bochs-${PV}.tar.gz \
           file://compile.patch;patch=1"

inherit autotools sdl

EXTRA_OECONF = "--without-x                 \
                --without-x11               \
                --without-beos              \
                --without-win32             \
                --without-macos             \
                --without-carbon            \
                --without-nogui             \
                --without-term              \
                --without-rfb               \
                --without-amigaos           \
                --with-sdl                  \
                --without-svga              \
                --without-wx"

do_compile() {
	oe_runmake bochs bximage bxcommit
}

do_install() {
	oe_runmake -i install # yes, ugly i know... but i can't get rid of that bailing out docbook crap atm.
}
