DESCRIPTION = "ANother Tool for Language Recognition, (formerly PCCTS) is a \
language tool that provides a framework for constructing recognizers, \
compilers, and translators from grammatical descriptions containing \
Java, C#, C++, or Python actions."
LICENSE = "PD"
MAINTAINER = "Chris Larson <kergoth@handhelds.org>"
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
