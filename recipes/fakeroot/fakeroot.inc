DESCRIPTION = "Gives a fake root environment"
HOMEPAGE = "http://fakeroot.alioth.debian.org"
SECTION = "base"
LICENSE = "GPL"
INC_PR = "r0"
inherit autotools
BBCLASSEXTEND = "native"

SRC_URI = "\
  file://configure-libtool.patch \
"
# previous versions did the following for -native, but why? Not needed..
#SRC_URI_append_virtclass-native = "file://fix-prefix.patch"

# fakeroot needs getopt which is provided by the util-linux package
RDEPENDS_${PN} = "util-linux"
