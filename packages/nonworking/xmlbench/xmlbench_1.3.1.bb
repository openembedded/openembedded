MAINTAINER = "Chris Larson <kergoth@handhelds.org>"
LICENSE = "GPLv2"
DEPENDS = "libxml2 expat"

SRC_URI = "${SOURCEFORGE_MIRROR}/xmlbench/xmlbench-${PV}.tar.bz2"
S = "${WORKDIR}/xmlbench"

EXTRA_OEMAKE = ""
do_compile () {
	oe_runmake 'gcc=${CC}' 'gpp=${CXX}' 'gppstd=${CXX}' 'LIBXML=yes' 'EXPAT=yes' 'LIBXML_INCLUDE=-I${STAGING_INCDIR}/libxml2' 'LIBXML_LIB=-L${STAGING_LIBDIR} -lxml2' 'EXPAT_LIB=-L${STAGING_LIBDIR} -lexpat' 'EXPAT_INCLUDE=-I${STAGING_INCDIR}' 'GDOME=no' 'LIBXSLT=no' 'XMLSEC=no' 'XMLSEC1=no' 'SABLOTRON=no' 'ARABICA=no' 'CSLXML=no' 'XERCESC=no' 'RXP=no' 'XDKC=no' 'XDKP=no' 'QT=no' 'XML4C=no' 'FLAGS=${CFLAGS} -I${STAGING_INCDIR}/libxml2' 'XDKJ=no' 'SUN=no' 'SUBDIRS=xmlgen parse create validate xsl security'
}

# FIXME:
# This package builds, but the benchmarks expect to run inside the
# source tree.  Need to hack up its scripts to put things in the correct
# locations, similar to what debian did to lmbench.
