DESCRIPTION = "CHMLIB is a library for dealing with Microsoft ITSS/CHM format files." 
LICENSE = "GPLv2"
HOMEPAGE = "http://66.93.236.84/~jedwin/projects/chmlib/"

SRC_URI = "http://66.93.236.84/~jedwin/projects/chmlib/${P}.tar.bz2 \
	   file://arm-guess.patch;patch=1"

inherit autotools pkgconfig



