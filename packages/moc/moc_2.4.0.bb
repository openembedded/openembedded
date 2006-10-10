DESCRIPTION = "MOC is a ncurses based music player"
SECTION = "console/multimedia"
DEPENDS = "ncurses"
LICENSE = "GPL"
AUTHOR = "Damian Pietras <daper@daper.net>"
HOMEPAGE = "http://moc.daper.net/"

SRC_URI = "ftp://ftp.daper.net/pub/soft/moc/stable/${PN}-${PV}.tar.bz2"

inherit autotools

FILES_${PN} = "${bindir}/moc"
