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

