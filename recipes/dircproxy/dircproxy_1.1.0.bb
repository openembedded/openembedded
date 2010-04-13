DESCRIPTION = "IRC proxy server"
HOMEPAGE = "http://dircproxy.securiweb.net/"
LICENSE = "GPLv2"
PR = "r1"

SRC_URI = "http://dircproxy.securiweb.net/pub/1.1/dircproxy-${PV}.tar.gz\
           file://dircproxy.patch;patch=1"

inherit autotools


SRC_URI[md5sum] = "066bd39d80f286ae5ce69a2adbbd01e4"
SRC_URI[sha256sum] = "f0be78d2c2f0279cce26b0b2e87077bfe568f1da189eef2daec78b1e12699c4e"
