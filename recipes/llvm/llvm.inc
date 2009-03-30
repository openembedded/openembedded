DESCRIPTION = "The Low Level Virtual Machine"
HOMEPAGE = "http://llvm.org"
LICENSE = "various"

SRC_URI = "http://llvm.org/releases/1.9/llvm-${PV}.tar.gz"

inherit autotools

do_configure() {
	oe_runconf
}

do_stage() {
	autotools_stage_all
}	

