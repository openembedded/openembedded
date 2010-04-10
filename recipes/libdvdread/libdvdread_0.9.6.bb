DESCRIPTION = "libdvdread provides a simple foundation for reading DVD video disks. \
It provides the functionality that is required to access many DVDs. \
It parses IFO files, reads NAV-blocks, and performs CSS authentication and descrambling."
HOMEPAGE = "http://www.dtek.chalmers.se/groups/dvd/development.shtml"
LICENSE = "GPL"
SECTION = "libs/multimedia"

SRC_URI = "http://www.dtek.chalmers.se/groups/dvd/dist/libdvdread-${PV}.tar.gz"

inherit autotools

do_stage() {
	autotools_stage_all
}


SRC_URI[md5sum] = "329401b84ad0b00aaccaad58f2fc393c"
SRC_URI[sha256sum] = "509503979441e078866d75a628d8a6483e67737454feaa5366f609ecf2a0f5cf"
