DESCRIPTION = "ZeroC Internet Comminication Engine (ICE) embedded"
HOMEPAGE = "http://www.zeroc.com/icee/index.html"
LICENSE = "GPLv2"
SECTION = "libs"
PR = "r0"

S = "${WORKDIR}/IceE-${PV}"

do_removebinary () {
	rm -rf ${S}/cpp/bin/slice2cppe
}
addtask removebinary before do_patch after do_unpack

do_install () {
	oe_runmake prefix=${D}${prefix} install
}
NATIVE_INSTALL_WORKS = "1"
