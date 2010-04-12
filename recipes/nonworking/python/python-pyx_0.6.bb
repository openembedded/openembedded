DESCRIPTION = "PyX is a Python package for the creation of encapsulated PostScript figures. \
It provides both an abstraction of PostScript and a TeX/LaTeX interface. Complex tasks like \
2d and 3d plots in publication-ready quality are built out of these primitives."
SECTION = "devel/python"
PRIORITY = "optional"
RDEPENDS = "python-core"
DEPENDS = "kpsewhich-native"
SRCNAME = "PyX"

SRC_URI = "${SOURCEFORGE_MIRROR}/pyx/${SRCNAME}-${PV}.tar.gz"
S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit distutils

SRC_URI[md5sum] = "2e9b5935d6a0695e57345c419e58d9d8"
SRC_URI[sha256sum] = "5f1e84d51b40c2e81dcb9cf708f5cf83ad140ec6d1d7f67e6e07b24cd2a1e1c3"
