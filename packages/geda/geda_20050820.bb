DESCRIPTION = "GUI/Project Manager for teh gEDA suite"
MAINTAINER = "Koen Kooi <koen@handhelds.org>"
LICENSE = "GPLv2"
HOMEPAGE = "http://geda.seul.org"
FILES_${PN} += "${datadir}/gEDA"
PR ="r1"

DEPENDS = "libgeda gtk+"
RRECOMMENDS = "geda-utils geda-gattrib geda-gnetlist geda-gschem geda-gsymcheck geda-symbols"

SRC_URI = "http://www.geda.seul.org/devel/${PV}/${P}.tar.gz"

inherit autotools pkgconfig
