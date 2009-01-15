DESCRIPTION = "libdvdread provides a simple foundation for reading DVD video disks. \
It provides the functionality that is required to access many DVDs. \
It parses IFO files, reads NAV-blocks, and performs CSS authentication and descrambling."
HOMEPAGE = "http://www.dtek.chalmers.se/groups/dvd/development.shtml"
LICENSE = "GPL"
DEPENDS = "libdvdcss"
SECTION = "libs/multimedia"

PR = "r1"

SRC_URI = "http://www.dtek.chalmers.se/groups/dvd/dist/libdvdread-${PV}.tar.gz"

inherit autotools

EXTRA_OECONF = " --with-libdvdcss-includes=${STAGING_INCDIR} \
                 --with-libdvdcss-libs=${STAGING_LIBDIR} \
"

do_stage() {
	autotools_stage_all
}

