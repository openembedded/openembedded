MAINTAINER = "Koen Kooi <koen@handhelds.org>"
LICENSE = "GPLv2"
HOMEPAGE = "http://geda.seul.org"
PR = "r1"

DEPENDS = "zlib gtk+ guile libpng"

SRC_URI = "http://www.geda.seul.org/devel/${PV}/${P}.tar.gz"

inherit autotools pkgconfig

do_stage() {
	autotools_stage_all
}
