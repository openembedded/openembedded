DESCRIPTION = "Packages required for native (on-device) SDK"
LICENSE = "MIT"
INC_PR = "r13"

inherit task

RPROVIDES_${PN} = "task-native-sdk"
RDEPENDS_${PN} = "gcc-symlinks g++-symlinks cpp cpp-symlinks binutils-symlinks \
	    make virtual-libc-dev \
	    task-proper-tools perl-modules flex flex-dev bison gawk sed grep autoconf automake make \
	    patch patchutils diffstat diffutils libstdc++-dev \
            libtool libtool-dev libltdl-dev pkgconfig"

RRECOMMENDS_${PN} = " g77-symlinks gfortran-symlinks cvs"
