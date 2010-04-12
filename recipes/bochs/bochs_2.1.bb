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

SRC_URI[md5sum] = "30bdb17e11fb416f9d3c6243e02f6e73"
SRC_URI[sha256sum] = "90ec337d482a0e766e1f24679324445057abfc2e01d9d2c1f561b40ac7f1915b"
