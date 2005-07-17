DESCRIPTION = "A compact Java Virtual Machine which conforms to the JVM specification version 2."
HOMEPAGE = "http://jamvm.sourceforge.net/"
LICENSE = "GPL"
PRIORITY = "optional"
MAINTAINER = "Rene Wagner <rw@handhelds.org>"
SECTION = "interpreters"

DEPENDS = "zlib classpath"
RDEPENDS = "classpath (>= 0.14) classpath-common (>= 0.14)"

SRC_URI = "${SOURCEFORGE_MIRROR}/${PN}/${P}.tar.gz \
           file://size-defaults.patch;patch=1"

inherit autotools update-alternatives

EXTRA_OECONF = "--with-classpath-install-dir=${prefix}"
CFLAGS += "-DDEFAULT_MAX_HEAP=16*MB"

PROVIDES = "virtual/java"
ALTERNATIVE_NAME = "java"
ALTERNATIVE_PATH = "${bindir}/jamvm"
ALTERNATIVE_PRIORITY = "10"
