DESCRIPTION = "gEDA/gaf's Utilities"
MAINTAINER = "Koen Kooi <koen@handhelds.org>"
LICENSE = "GPLv2"
HOMEPAGE = "http://geda.seul.org"

DEPENDS = "libgeda"

SRC_URI = "http://www.geda.seul.org/devel/${PV}/${P}.tar.gz"

inherit autotools pkgconfig
