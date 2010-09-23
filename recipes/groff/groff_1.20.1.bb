DESCRIPTION = "GNU roff"
SECTION = "base"
LICENSE = "GPL"
PR = "r1"

SRC_URI = "http://ftp.gnu.org/gnu/groff/groff-${PV}.tar.gz \
          "
SRC_URI[md5sum] = "48fa768dd6fdeb7968041dd5ae8e2b02"
SRC_URI[sha256sum] = "b645878135cb620c6c417c5601bfe96172245af12045540d7344938b4c2cd805"

inherit autotools

do_configure_prepend(){
	if [ "${BUILD_SYS}" != "${HOST_SYS}" ]; then
		sed -i \
		    -e '/^GROFFBIN=/s:=.*:=echo:' \
		    -e '/^TROFFBIN=/s:=.*:=echo:' \
		    -e '/^GROFF_BIN_PATH=/s:=.*:=:' \
		    -e '/^GROFF_BIN_DIR=/s:=.*:=:' \
		    ${S}/contrib/*/Makefile.sub \
		    ${S}/doc/Makefile.in \
		    ${S}/doc/Makefile.sub
	fi
}

BBCLASSEXTEND = "native"
