JAVA = ""
FORTRAN = ""
OBJC = ""
SHARED_LIBRARIES = "no"
EXTRA_OECONF_append_nios2 = " --enable-cxx-flags=-static "
require gcc-common.inc
#DEPENDS += "elf2flt-cross"

BINV = "3.4.6"
PV = "nios2-3.4.6"

GCCREV = "b773f7eccc6cc2ffa8fa2bd201ea62f24ba0bb41"
SRCREV = "b773f7eccc6cc2ffa8fa2bd201ea62f24ba0bb41"

SRC_URI = "git://sopc.et.ntust.edu.tw/git/gcc3.git;protocol=http;branch=nios2-linux"

S = "${WORKDIR}/git"

SRC_URI += "file://gcc-posix-open-fix.patch;patch=1"
