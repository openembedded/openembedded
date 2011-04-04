DESCRIPTION = "AVRGAL is a hacked light version of AVRDUDE intended to make it easier to cross compile and use for uploading programs to the Arduino boootloader"
HOMEPAGE = "http://elinux.org/Avrgal"
SECTION = "console"
LICENSE = "GPLv2"

DEPENDS = "virtual/libusb0 ncurses"

SRC_URI = "http://elinux.org/images/8/8a/Avrgal.tar.gz"

inherit autotools

TARGET_CC_ARCH += "${LDFLAGS}"

do_install() {
	mkdir -p ${D}${bindir}
	install -m 0755 ${S}/avrgal ${D}${bindir}
}

SRC_URI[md5sum] = "7af51d301edf8548314d28d6d2cc1bc0"
SRC_URI[sha256sum] = "43bc8442ea9c0df2a5e172cea8630969c541025587eb8c81f0eb703ac6a2d709"
