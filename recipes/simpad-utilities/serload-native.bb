DESCRIPTION = "Console utility for transferring a SIMpad boot image via serial a SIMpad"
SECTION = "console/utils"
LICENSE = "GPL"
PR = "r1"

SRC_URI = "file://serialdownload.cpp file://main.cpp file://serialdownload.h"

inherit native

do_compile() {
        cp ${WORKDIR}/*.h ${WORKDIR}/*.cpp .
        ${CXX} -I. -o serload main.cpp serialdownload.cpp
}
do_install() {
        install -d ${D}${bindir}/
        install -m 0755 serload ${D}${bindir}/
}

NATIVE_INSTALL_WORKS = "1"
