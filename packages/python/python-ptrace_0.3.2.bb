DESCRIPTION = "python-ptrace is a debugger using ptrace."
HOMEPAGE = "http://fusil.hachoir.org/trac/wiki/python-ptrace"
SECTION = "devel/python"
LICENSE = "GPLv2"
PR = "ml0"

SRC_URI = "http://pypi.python.org/packages/source/p/ptrace/ptrace-${PV}.tar.gz"
S = "${WORKDIR}/ptrace-${PV}"

inherit distutils
