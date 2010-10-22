DESCRIPTION = "The httperf HTTP load generator"
HOMEPAGE = "http://code.google.com/p/httperf/"
LICENSE = "GPLv2+"
DEPENDS = "openssl"

SRC_URI = "http://httperf.googlecode.com/files/httperf-${PV}.tar.gz"
SRC_URI[md5sum] = "2968c36b9ecf3d98fc1f2c1c9c0d9341"
SRC_URI[sha256sum] = "e1a0bf56bcb746c04674c47b6cfa531fad24e45e9c6de02aea0d1c5f85a2bf1c"

inherit autotools