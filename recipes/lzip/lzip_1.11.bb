DESCRIPTION = "Lzip is a lossless data compressor based on the LZMA algorithm"
HOMEPAGE = "http://lzip.nongnu.org/lzip.html"
LICENSE = "GPLv3+"
PR = "1"

SRC_URI = "${SAVANNAH_MIRROR}/releases/lzip/lzip-${PV}.tar.gz"
SRC_URI[md5sum] = "ba9d0a705e47bcd2b73145d238aa7b58"
SRC_URI[sha256sum] = "c3cfd2396733f6817b25a2bd1b019447ac2fa692f6fe5dc477631a9dbb31b00b"

CONFIGUREOPTS = "\
    '--srcdir=${S}' \
    '--prefix=${prefix}' \
    '--exec-prefix=${exec_prefix}' \
    '--bindir=${bindir}' \
    '--datadir=${datadir}' \
    '--infodir=${infodir}' \
    '--sysconfdir=${sysconfdir}' \
    'CXX=${CXX}' \
    'CPPFLAGS=${CPPFLAGS}' \
    'CXXFLAGS=${CXXFLAGS}' \
    'LDFLAGS=${LDFLAGS}' \
"
EXTRA_OEMAKE = ""

B = "${S}/obj"
do_configure () {
    ${S}/configure ${CONFIGUREOPTS}
}

do_install () {
    oe_runmake 'DESTDIR=${D}' install
}

BBCLASSEXTEND += "native nativesdk"
