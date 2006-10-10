DESCRIPTION=GNU Scientific Library Python Bindings
SECTION=base
PRIORITY=optional
RDEPENDS=python-core gsl
DEPENDS=gsl
SRCNAME=pygsl

SRC_URI = ${SOURCEFORGE_MIRROR}/${SRCNAME}/${SRCNAME}-${PV}.tar.gz \
          file://${FILESDIR}/cross-compile.patch;patch=1
S = ${WORKDIR}/${SRCNAME}-${PV}

inherit distutils

export STAGING=${STAGING_DIR}
