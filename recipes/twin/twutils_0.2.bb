DESCRIPTION = "Utilities for twin. Currently contains 'twkalc', a calculator derived from kcalc."
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

SRC_URI[md5sum] = "313d47ae27c3c4d51317626421c78284"
SRC_URI[sha256sum] = "e4ac5c2a59e1c9f80b19c5703240e125592018f40972c2628171d0eeddd15e7b"
