DESCRIPTION = "Utilities for twin. Currently contains 'twkalc', a calculator derived from kcalc."
MAINTAINER = "Chris Lord <cwiiis@blueyonder.co.uk>"
DEPENDS = "twin"

SECTION = "console/utils"
LICENSE = "GPL LGPL"
SRC_URI = "http://linuz.sns.it/~max/twin/twutils-0.2.tar.gz"

inherit autotools

CXXFLAGS_append = " -DHAVE_FUNC_ISINF"
LDFLAGS_append = " -L${STAGING_LIBDIR}"

do_compile() {
	for i in admin twkalc
	do
		cd ${S}/$i && oe_runmake LDFLAGS="${LDFLAGS}"
	done
}
