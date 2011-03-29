DESCRIPTION = "This small package provides a few command line tools for Linux Phonet"
HOMEPAGE = ""
LICENSE = "GPL2"
SRC_URI = "git://gitorious.org/meego-cellular/phonet-utils.git;branch=master;protocol=git"
PR = "r0"
S = "${WORKDIR}/git"
SRCREV = "4acfa720fd37d178a048fc2be17180137d4a70ea"
PV = "0.0.0+gitr${SRCPV}"

do_compile () {
	make
}

do_install () {
	DESTDIR=${D} oe_runmake install
}

