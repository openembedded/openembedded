JAVA = ""
FORTRAN = ""
OBJC = ""
SHARED_LIBRARIES = "no"
DEPENDS += " elf2flt-cross "
EXTRA_OECONF_append_nios2 = " --enable-cxx-flags=-static "
require gcc-common.inc

BINV = "3.4.6"
PV = "nios2-3.4.6"

SRC_URI = "git://sopc.et.ntust.edu.tw/git/gcc3.git;protocol=git;branch=nios2-linux;tag=b773f7eccc6cc2ffa8fa2bd201ea62f24ba0bb41"
S = "${WORKDIR}/git"
