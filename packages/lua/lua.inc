DESCRIPTION = "Lua is a powerful light-weight programming language designed \
for extending applications."
LICENSE = "MIT"
HOMEPAGE = "http://www.lua.org/"

PACKAGES = "liblua-dbg liblualib-dbg ${PN}-dbg \
liblua-dev liblua liblualib-dev liblualib ${PN}-doc ${PN}"

FILES_${PN}-dbg = "${bindir}/.debug"
FILES_liblua-dbg = "${libdir}/.debug/liblua.so.*"
FILES_liblualib-dbg = "${libdir}/.debug/liblualib.so.*"

FILES_${PN} = "${bindir}"
FILES_${PN}-doc = "${mandir}"

FILES_liblua = "${libdir}/liblua.so.*"
FILES_liblua-dev = "${libdir}/liblua.so ${libdir}/liblua.a \
		    ${includedir}/lua.h"
FILES_liblualib = "${libdir}/liblualib.so.*"
FILES_liblualib-dev = "${libdir}/liblualib.so ${libdir}/liblualib.a \
		       ${includedir}/lualib.h ${includedir}/lauxlib.h"
SECTION_${PN} = "interpreters"
SECTION_${PN}-doc = "doc"
SECTION_liblua = "libs"
SECTION_liblua-dev = "devel"
SECTION_liblualib = "libs"
SECTION_liblualib-dev = "devel"
