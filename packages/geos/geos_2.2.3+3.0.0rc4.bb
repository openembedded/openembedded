DESCRIPTION = "GEOS (Geometry Engine - Open Source) is a C++ port of the Java Topology Suite (JTS)."
HOMEPAGE = "http://geos.refractions.net/"
LICENSE = "GPLv2""

DEPENDS = "boost"

PR = "r1"

SRC_URI = "http://geos.refractions.net/geos-3.0.0rc4.tar.bz2"

S = "${WORKDIR}/geos-3.0.0rc4"

inherit autotools pkgconfig lib_package binconfig

EXTRA_OECONF = "--disable-swig"

do_stage() {
       autotools_stage_all
}       


