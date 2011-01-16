DESCRIPTION = "MOC is a ncurses based music player"
AUTHOR = "Damian Pietras <daper@daper.net>"
HOMEPAGE = "http://moc.daper.net/"
SECTION = "console/multimedia"
LICENSE = "GPL"
DEPENDS = "ncurses flac"
PR = "r0"

SRC_URI = "${SOURCEFORGE_MIRROR}/${PN}/${P}.tar.bz2"

inherit autotools

EXTRA_OECONF = "--without-flac"

FILES_${PN}-dbg += "${libdir}/moc/decoder_plugins/.debug"

SRC_URI[md5sum] = "647c770a5542a4ae5437386807a89796"
SRC_URI[sha256sum] = "26bf5707128def20d8b69c0f0c3624a82b7f72c36280bcf86b9b5e8bf8d08b05"
