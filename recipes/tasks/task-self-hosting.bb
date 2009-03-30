DESCRIPTION = "All tools needed for OpenEmbedded build"
SECTION = "devel"
LICENSE = "MIT"
RDEPENDS = "cpp gcc-symlinks binutils-symlinks \
            perl perl-modules bitbake bash \
			task-proper-tools glibc-utils \
			linux-libc-headers-dev glibc-dev \
			texinfo make cvs subversion monotone-6"

#
# quilt-native REQ bash and perl/perl-modules
# binutils REQ texinfo
#
# bitbake will fetch all needed python modules
#
# toolchain:
# - gcc-symlinks will fetch gcc
# - binutils-symlinks will fetch binutils
# - glibc-utils REQ cpp
#
# problems:
# - binutils-symlinks conflict with busybox
# - glibc-dev conflict with libc-linux-headers-dev
# - perl is so granulated that it is probably impossible
#   to find out which packages are needed
#

ALLOW_EMPTY = "1"

PACKAGES = "${PN}"
PACKAGE_ARCH = "all"
