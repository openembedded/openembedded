DESCRIPTION = "Lua is a powerful light-weight programming language designed \
for extending applications."
LICENSE = "MIT"
HOMEPAGE = "http://www.lua.org/"
MAINTAINER = "Chris Larson <kergoth@handhelds.org>"

PACKAGES = "${PN} liblua ${PN}-doc liblua-dev \
	    liblualib liblualib-dev"
FILES_${PN} = "${bindir}/lua ${bindir}/luac"
FILES_${PN}-doc = "${mandir}/man1/lua.1 ${mandir}/man1/luac.1"
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
