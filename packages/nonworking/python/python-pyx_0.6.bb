DESCRIPTION = "PyX is a Python package for the creation of encapsulated PostScript figures. \
It provides both an abstraction of PostScript and a TeX/LaTeX interface. Complex tasks like \
2d and 3d plots in publication-ready quality are built out of these primitives."
SECTION = "devel/python"
PRIORITY = "optional"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"
RDEPENDS = "python-core"
DEPENDS = "kpsewhich-native"
SRCNAME = "PyX"

SRC_URI = "${SOURCEFORGE_MIRROR}/pyx/${SRCNAME}-${PV}.tar.gz"
S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit distutils
