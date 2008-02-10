DESCRIPTION = "Python SQL toolkit and Object Relational Mapper that gives application developers the full power and flexibility of SQL"
HOMEPAGE = "http://www.sqlalchemy.org/"
SECTION = "devel/python"
PRIORITY = "optional"
LICENSE = "MIT"          
DEPENDS = "python-setuptools"
#RDEPENDS = ""
SRCNAME = "sqlalchemy"
PR = "r0"

SRC_URI = "${SOURCEFORGE_MIRROR}/${SRCNAME}/SQLAlchemy-${PV}.tar.gz"
S = "${WORKDIR}/${SRCNAME}-${PV}"

#inherit distutils
