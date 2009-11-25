FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/binutils-${PV}"
require binutils_${PV}.bb
require binutils-cross.inc

# nios2-linux-uclibc-ar suffers from errors against FORTIFY_SOURCE checks on
# GCC 4.3+ with _FORTIFY_SOURCE enabled. Either fix the bugs, take an older
# host toolchain, or disable the checks. We disable the checks:
CFLAGS += "-U_FORTIFY_SOURCE"

