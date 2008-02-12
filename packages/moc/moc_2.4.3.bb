DESCRIPTION = "MOC is a ncurses based music player"
AUTHOR = "Damian Pietras <daper@daper.net>"
HOMEPAGE = "http://moc.daper.net/"
SECTION = "console/multimedia"
LICENSE = "GPL"
DEPENDS = "ncurses flac"

SRC_URI = "ftp://ftp.daper.net/pub/soft/moc/stable/${PN}-${PV}.tar.bz2"

inherit autotools

EXTRA_OECONF = "--without-flac"

FILES_${PN}-dbg += "${libdir}/moc/decoder_plugins/.debug"
