DESCRIPTION = "The Low Level Virtual Machine - gcc4 frontend"
HOMEPAGE = "http://llvm.org"
LICENSE = "various"

DEPENDS = "llvm2.5-native"

PV = "2.1+svnr${SRCPV}"

PR = "r1"

inherit autotools cross

SRC_URI = "svn://anonsvn.opensource.apple.com/svn/llvm/;module=trunk \
	   "
	   
S = "${WORKDIR}/trunk"

EXTRA_OECONF = "--disable-shared \
                --enable-llvm=/data/build/koen/OE/build/tmp/angstrom/work/i686-linux/llvm-native-2.0-r0/llvm-2.0 \
	       "

do_configure() {
	gnu-configize
	libtoolize --force
	oe_runconf
}	

PARALLEL_MAKE = ""

#oe_runmake gets distracted by GNUMakefiles...
# we also need to get an install.sh and config-ml.in in gcc/ as well somehow
do_compile_prepend() {
	rm -f ${S}/GNUmakefile
}	
