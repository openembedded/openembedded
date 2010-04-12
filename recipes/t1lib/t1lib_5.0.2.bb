DESCRIPTION = "A Type1 Font Rastering Library"
SECTION = "libs"
PRIORITY = "optional"
DEPENDS = "virtual/libx11 libxaw"

PR = "r6"

LICENSE = "LGPL GPL"
SRC_URI = "${DEBIAN_MIRROR}/main/t/t1lib/t1lib_${PV}.orig.tar.gz \
           file://configure.patch;patch=1 \
           file://install.patch;patch=1 \
	   file://libtool.patch;patch=1"

inherit autotools

# Fix GNU_HASH problem
TARGET_CC_ARCH += "${LDFLAGS}"

EXTRA_OECONF = "--with-x --without-athena"
EXTRA_OEMAKE = "without_doc"

do_configure() {
	rm -f ${S}/ac-tools/aclocal.m4
	autotools_do_configure
}

FILES_${PN} = "${bindir}/* ${libdir}/*.so* ${datadir}/t1lib/t1lib.config"
FILES_${PN}-doc = "${datadir}/t1lib/doc/t1lib_doc.pdf"

SRC_URI[md5sum] = "cc5d4130b25bb8a1c930488b78930e9b"
SRC_URI[sha256sum] = "34ff6a85d1dae64d06b5aca04fb17822dd26a734f40cd966e3dd980afa4a037a"
