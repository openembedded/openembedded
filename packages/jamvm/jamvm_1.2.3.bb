DESCRIPTION = "A compact Java Virtual Machine which conforms to the JVM specification version 2."
HOMEPAGE = "http://jamvm.sourceforge.net/"
LICENSE = "GPL"
PRIORITY = "optional"
MAINTAINER = "Rene Wagner <rw@handhelds.org>"
SECTION = "interpreters"
PR = "r1"

DEPENDS = "zlib classpath"
RDEPENDS = "classpath classpath-common"

SRC_URI = "${SOURCEFORGE_MIRROR}/${PN}/${P}.tar.gz"

inherit autotools update-alternatives

EXTRA_OECONF = "--with-classpath-install-dir=${prefix}"

PROVIDES = "virtual/java"
ALTERNATIVE_NAME = "java"
ALTERNATIVE_PATH = "${bindir}/jamvm"
ALTERNATIVE_PRIORITY = "10"
