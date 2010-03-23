DESCRIPTION = "GEOS (Geometry Engine - Open Source) is a C++ port of the Java Topology Suite (JTS)."
HOMEPAGE = "http://geos.refractions.net/"
LICENSE = "LGPL"

DEPENDS = "boost"

PR = "r0"

SRC_URI = "http://download.osgeo.org/geos/geos-${PV}.tar.bz2;name=geos \
	   file://geos-arm.patch;patch=1 \
	  "

S = "${WORKDIR}/geos-${PV}"

inherit autotools pkgconfig lib_package binconfig

EXTRA_OECONF = "--disable-swig"
SRC_URI[geos.md5sum] = "bfad7129680f0107b6ca9a2b92a2c440"
SRC_URI[geos.sha256sum] = "0a43b76429fd94fd572d79869f3ca5acdf44a9fa73844aa655016f09aaa1e6c7"

