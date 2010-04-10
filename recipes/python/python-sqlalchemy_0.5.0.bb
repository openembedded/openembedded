DESCRIPTION = "Python SQL toolkit and Object Relational Mapper that gives \
application developers the full power and flexibility of SQL"
HOMEPAGE = "http://www.sqlalchemy.org/"
SECTION = "devel/python"
PRIORITY = "optional"
LICENSE = "MIT"          
SRCNAME = "SQLAlchemy"
PR = "ml0"

SRC_URI = "${SOURCEFORGE_MIRROR}/sqlalchemy/${SRCNAME}-${PV}.tar.gz"
S = "${WORKDIR}/${SRCNAME}-${PV}"

inherit setuptools

SRC_URI[md5sum] = "df49f403b2db3c54aace64aebe26cf90"
SRC_URI[sha256sum] = "30c1649025f76e414400edd957f46b2932b5d3f8e2404779c76e693cb5776949"
