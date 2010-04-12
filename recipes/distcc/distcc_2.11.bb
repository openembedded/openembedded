SECTION = "devel"
LICENSE = "GPLv2"
DESCRIPTION = "distcc is a parallel build system that distributes \
compilation of C/C++/ObjC code across machines on a network."

SRC_URI = "http://distcc.samba.org/ftp/distcc/distcc-${PV}.tar.bz2"

inherit autotools

SRC_URI[md5sum] = "f3458779c13255d88ee89ea7ccddda29"
SRC_URI[sha256sum] = "00ca6747501d1b6034398ba5482dcb1e7cf3aff8739fbff0c72e58602d68774c"
