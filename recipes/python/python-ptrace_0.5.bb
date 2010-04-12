DESCRIPTION = "python-ptrace is a debugger using ptrace."
HOMEPAGE = "http://python-ptrace.hachoir.org/trac"
SECTION = "devel/python"
LICENSE = "GPLv2"
PR = "ml0"

SRC_URI = "http://pypi.python.org/packages/source/p/python-ptrace/python-ptrace-${PV}.tar.gz"

inherit distutils

SRC_URI[md5sum] = "0df3d1c5109bb88d06575d70513a190c"
SRC_URI[sha256sum] = "8ff2ec30050803e8b60cfb05d24fa32b3d175bffb81ef5919c3db4ac0f263df8"
