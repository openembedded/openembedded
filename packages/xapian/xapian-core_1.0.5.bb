DESCRPITION = "Open Source Search Engine Library"
HOMEPAGE = "http://xapian.org"
SECTION = "devel/libs"
PRIORITY = "optional"
LICENSE = "GPL"
DEPENDS = "zlib"
PR = "r0"

SRC_URI = "http://www.oligarchy.co.uk/xapian/1.0.5/xapian-core-${PV}.tar.gz"

inherit autotools

do_stage () {
     autotools_stage_all
}

