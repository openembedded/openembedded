HOMEPAGE = "http://www.agroman.net/corkscrew/"
DESCRIPTION = "Tunnel SSH throught HTTP proxies"
LICENSE = "GPL"
SECTION = "console/network"
SRC_URI = "http://www.agroman.net/corkscrew/corkscrew-${PV}.tar.gz \
	   file://configure.patch;patch=1"

inherit autotools

SRC_URI[md5sum] = "35df77e7f0e59c0ec4f80313be52c10a"
SRC_URI[sha256sum] = "0d0fcbb41cba4a81c4ab494459472086f377f9edb78a2e2238ed19b58956b0be"
