DESCRIPTION = "strace is a system call tracing tool."
SECTION = "console/utils"
LICENSE = "BSD"
PR = "r1"

SRC_URI = "${SOURCEFORGE_MIRROR}/strace/strace-${PV}.tar.bz2 \
          file://mips-nolargefile.patch \
          "

inherit autotools

export INCLUDES = "-I. -I./linux"

SRC_URI[md5sum] = "64dfe10d9db0c1e34030891695ffca4b"
SRC_URI[sha256sum] = "ea8c059369eaa5ad90b246f34eab247d0ee48bfdee2670c7196320a4669ccabd"
