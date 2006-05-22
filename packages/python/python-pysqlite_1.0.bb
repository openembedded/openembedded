DESCRIPTION = "A Python extension for the SQLite Embedded Relational Database"
SECTION = "devel/python"
PRIORITY = "optional"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"
LICENSE = "PSF"
RDEPENDS = "python-core python-re python-lang"
DEPENDS = "sqlite"
SRCNAME = "pysqlite"
PR = "ml0"

SRC_URI = "${SOURCEFORGE_MIRROR}/${SRCNAME}/${SRCNAME}-${PV}.tar.gz \
           file://no-host-includes.patch;patch=1"
S = "${WORKDIR}/${SRCNAME}"

inherit distutils
