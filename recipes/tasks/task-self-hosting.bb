DESCRIPTION = "All tools needed for OpenEmbedded build"
SECTION = "devel"
LICENSE = "MIT"
RDEPENDS_${PN} = "task-native-sdk python-modules bash texinfo cvs subversion git"
PR = "r2"

#
# quilt-native REQ bash and perl/perl-modules
# binutils REQ texinfo
#
# Bitbake require Python and should be fetched from GIT tree
#
# toolchain:
# - task-native-sdk provides it for glibc/uclibc systems

ALLOW_EMPTY = "1"

PACKAGES = "${PN}"
PACKAGE_ARCH = "all"
