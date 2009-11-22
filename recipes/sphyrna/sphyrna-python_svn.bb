DESCRIPTION = "Sphyrna - Hammerhead Reverse Engineering"
HOMEPAGE = "http://projects.linuxtogo.org/projects/sphyrna"
LICENSE = "GPLv2"
DEPENDS = "readline"
PV = "0.0+svnr${SRCPV}"
PR = "r1"

SRC_URI = "svn://projects.linuxtogo.org/svn;module=sphyrna"

S = "${WORKDIR}/sphyrna"

inherit autotools

PACKAGES = "${PN}-dbg sphyrna-console sphyrna-python"

FILES_sphyrna-console = "${bindir}/hhconsole"
FILES_sphyrna-python = "${bindir}/decode.py ${libdir}/python*/site-packages/sphyrna/*"

PACKAGE_ARCH_sphyrna-python = "all"
RDEPENDS_sphyrna-python = "python-core python-re"
