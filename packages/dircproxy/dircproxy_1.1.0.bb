DESCRIPTION = "IRC proxy server"
HOMEPAGE = "http://dircproxy.securiweb.net/"
LICENSE = "GPLv2"
PR = "r1"

SRC_URI = "http://dircproxy.securiweb.net/pub/1.1/dircproxy-${PV}.tar.gz\
           file://dircproxy.patch;patch=1"

inherit autotools

