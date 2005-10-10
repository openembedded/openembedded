DESCRIPTION = "GUI/Project Manager for teh gEDA suite"
MAINTAINER = "Koen Kooi <koen@handhelds.org>"
LICENSE = "GPLv2"
HOMEPAGE = "http://geda.seul.org"

DEPENDS = "libgeda gtk+"

SRC_URI = "http://www.geda.seul.org/devel/${PV}/${P}.tar.gz"

inherit autotools pkgconfig
