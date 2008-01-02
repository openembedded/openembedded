DESCRIPTION = " dot.conf is an easy to use and powerful configuration file parser library"
HOMEPAGE = "http://www.azzit.de/dotconf/"
LICENSE = "LGPLv2"

PR = "r0"

inherit autotools

SRC_URI = "http://www.azzit.de/dotconf/download/v1.0/${PN}-${PV}.tar.gz \
	  file://srcMakefile.am_00.patch;patch=1"
