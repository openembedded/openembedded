DESCRIPTION = "GEOS (Geometry Engine - Open Source) is a C++ port of the Java Topology Suite (JTS). GEOS provides a spatial object model and fundamental geometric functions. It implements the geometry model defined in the OpenGIS Consortium Simple Features Specification for SQL"
HOMEPAGE = "http://geos.refractions.net/"
LICENSE = "LGPL"

PR = "r1"

SRC_URI = "http://download.osgeo.org/geos/geos-${PV}.tar.bz2;name=geos \
	   file://geos-arm.patch;patch=1 \
	  "

S = "${WORKDIR}/${PN}-${PV}"

inherit autotools pkgconfig lib_package binconfig

PACKAGES += "${PN}-c1"

DESCRIPTION_${PN}-c1 = "Geometry engine for Geographic Information Systems - C Library"
FILES_${PN}-c1 := "${libdir}/libgeos_c.so.*"

DESCRIPTION_${PN} = "Geometry engine for Geographic Information Systems - C++ Library"
FILES_${PN} := "${libdir}/libgeos-*"

# --disable-inline is not needed if gcc 4.4+ is used
EXTRA_OECONF = "--disable-swig --disable-inline"

SRC_URI[geos.md5sum] = "bfad7129680f0107b6ca9a2b92a2c440"
SRC_URI[geos.sha256sum] = "0a43b76429fd94fd572d79869f3ca5acdf44a9fa73844aa655016f09aaa1e6c7"

