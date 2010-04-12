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

SRC_URI[md5sum] = "8808082848e90eeec5415baaec7e98ad"
SRC_URI[sha256sum] = "8598bb4f65e0b7d2a669e06222e6ba5eb1127b52b9a30136b2a823ccee10929f"
