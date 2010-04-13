DESCRIPTION = "Portable Bandwidth Monitor and rate estimator"
HOMEPAGE = "http://people.suug.ch/~tgr/bmon/"
SECTION = "console/utils"
LICENSE = "MIT"
# only works with libnl-0.5.0
DEPENDS = "libnl"

SRC_URI = "http://people.suug.ch/~tgr/bmon/files/bmon-2.1.0.tar.gz \
           file://no-strip.patch;patch=1"

inherit autotools

do_compile() {
    oe_runmake
}

SRC_URI[md5sum] = "3111a027907016c0902d67350c619df6"
SRC_URI[sha256sum] = "36a5772fc0241298b15db3dc4fb2552dcbb43edeffd6fcea4cd8818e97ec99fe"
