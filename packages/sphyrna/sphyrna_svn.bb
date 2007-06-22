DESCRIPTION = "Sphyrna - Hammerhead Reverse Engineering"
HOMEPAGE = "http://projects.linuxtogo.org/projects/sphyrna"
LICENSE = "GPLv2"
DEPENDS = "readline"
PV = "0.0+svn${SRCDATE}"
PR = "r0"

SRC_URI = "svn://projects.linuxtogo.org/svn;module=sphyrna"

S = "${WORKDIR}/${PN}"

inherit autotools

PACKAGES = "sphyrna-console"

FILES_sphyrna-console = "${bindir}/hhconsole"

