DESCRIPTION = "fantasy turn-based strategy game"
PV = "0.01+svnr${SRCPV}"
PR = "r1"
SECTION = "games"
LICENSE = "GPL"
DEPENDS += "libsdl-image libsdl-mixer libsdl-net"
SRC_URI = "svn://svn.gna.org/svn/wesnoth;module=trunk;proto=http"

EXTRA_OECONF += " --enable-tinygui --disable-python --enable-lite --enable-lowmem"

S = "${WORKDIR}/trunk"

inherit autotools

addtask autogen after do_patch before do_configure

do_autogen() {
        cd ${WORKDIR}/trunk/ && ./autogen.sh --host=armv4t-angstrom-linux-gnueabi
}
