DESCRIPTION = "A Go/Weiqi/Baduk playing engine."
HOMEPAGE = "http://www.gnu.org/software/gnugo/gnugo.html"
SECTION = "console"
PRIORITY = "optional"
LICENSE = "GPL"

SRC_URI = "${GNU_MIRROR}/gnugo/${PN}-${PV}.tar.gz \
file://0001-Add-AC_CANONICAL_BUILD-for-cross-build-support.patch \
file://0002-Add-support-for-BUILD_-for-cross-building.patch \
file://0003-Make-libs-also-generate-native-versions-use-them-whe.patch \
file://0004-Autotools-refresh.patch \
"

PR = "r0"

inherit autotools
EXTRA_OEMAKE = 'BUILD_CC="$BUILD_CC" BUILD_LD="$BUILD_LD" BUILD_CFLAGS="$BUILD_CFLAGS" BUILD_LDFLAGS="$BUILD_LDFLAGS"'

# FIXME: should verify those checksums through other means
SRC_URI[md5sum] = "6db0a528df58876d2b0ef1659c374a9a"
SRC_URI[sha256sum] = "da68d7a65f44dcf6ce6e4e630b6f6dd9897249d34425920bfdd4e07ff1866a72"
