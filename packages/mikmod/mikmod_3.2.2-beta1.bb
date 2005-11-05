DESCRIPTION = "A module player based on libmikmod."
SECTION = "console/multimedia"
HOMEPAGE = "http://mikmod.raphnet.net"
MAINTAINER = "Michael 'Mickey' Lauer"
DEPENDS = "libmikmod"
PR = "r1"
LICENSE = "GPL"
SRC_URI = "http://mikmod.raphnet.net/files/mikmod-${PV}.tar.bz2 \
           file://m4.patch;patch=1"

inherit autotools 

LDFLAGS_append = " -lm"
