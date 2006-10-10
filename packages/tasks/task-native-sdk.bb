DESCRIPTION = "Packages required for native (on-device) SDK"
LICENSE = "MIT"
DEPENDS = "gcc binutils make patch patchutils diffstat diffutils automake flex bison gawk sed grep"
RDEPENDS = "gcc-symlinks g++-symlinks binutils-symlinks make libc6-dev \
	    flex flex-dev bison gawk sed grep autoconf automake make \
	    patch patchutils diffstat diffutils libgcc-s-dev libstdc++-dev"

ALLOW_EMPTY = "1"
PACKAGES = "${PN}"
