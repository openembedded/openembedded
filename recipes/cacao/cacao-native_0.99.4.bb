# 0.99.4 appears to be broken on amd64 and i386 :(
DEFAULT_PREFERENCE = "-1"

require cacao-native.inc

PR = "r0"

SRC_URI = "http://www.complang.tuwien.ac.at/cacaojvm/download/cacao-${PV}/cacao-${PV}.tar.bz2"

SRC_URI[md5sum] = "63220327925ace13756ae334c55a3baa"
SRC_URI[sha256sum] = "1dfc4903dc0172286df4f1740fd0f12749ac81d51c602290b47cbe83d51e1d56"
