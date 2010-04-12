DESCRIPTION = "ANother Tool for Language Recognition, (formerly PCCTS) is a \
language tool that provides a framework for constructing recognizers, \
compilers, and translators from grammatical descriptions containing \
Java, C#, C++, or Python actions."
LICENSE = "PD"
PRIORITY = "optional"
SECTION = "devel"
# DEPENDS += "virtual/java"
RDEPENDS += "java-virtual-machine"

SRC_URI = "http://www.antlr.org/download/antlr-${PV}.tar.gz \
	   file://install.patch;patch=1"
S = "${WORKDIR}/antlr-${PV}"

inherit autotools

EXTRA_OECONF += "--disable-java --enable-cxx \
		 --disable-python --disable-csharp \
		 --disable-verbose --disable-examples"

do_configure () {
	if [ ! -e acinclude.m4 ]; then
		mv aclocal.m4 acinclude.m4
	fi
	autotools_do_configure
}

SRC_URI[md5sum] = "1ef201f29283179c8e5ab618529cac78"
SRC_URI[sha256sum] = "744d8f3a8206fbc45a5558d92163d5ef7e5e0cc0700283bb6a617fb1201629f9"
