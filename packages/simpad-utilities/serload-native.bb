SECTION = "console/utils"
LICENSE= "GPL"
DESCRIPTION = "Console utility for transferring a SIMpad boot image via serial a SIMpad"
FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/serload"
SRC_URI = "file://serialdownload.cpp file://main.cpp file://serialdownload.h"

inherit native

do_compile() {
	cp ${WORKDIR}/*.h ${WORKDIR}/*.cpp .
	${CXX} -I. -o serload main.cpp serialdownload.cpp
}

do_stage() {
	install -m 0755 serload ${STAGING_BINDIR}/
}
