DESCRIPTION = "Test suite for the PaX kernel patch"
HOMEPAGE = "http://www.grsecurity.net/~spender/"
LICENSE = "GPLv2+"

SRC_URI = "http://www.grsecurity.net/~spender/paxtest-${PV}.tgz"
SRC_URI[md5sum] = "7599f41823c73174d056d01b12ae5662"
SRC_URI[sha256sum] = "caca340492dedeee588d47683efde9797cba4fce5adca5d5f9b0b73b2120e1ab"

COMPATIBLE_HOST = "(x86_64|i.86)*"

PARALLEL_MAKE = ""

EXTRA_OEMAKE = "-e -f Makefile.psm"

CFLAGS += "-D_FORTIFY_SOURCE=0 -DRUNDIR=\\"${RUNDIR}\\""

export RUNDIR="${libexecdir}/paxtest"
export SHLDFLAGS="${LDFLAGS}"

do_install() {
	oe_runmake DESTDIR=${D} BINDIR=${bindir} install
}

FILES_${PN}-dbg += "${libexecdir}/paxtest/.debug"