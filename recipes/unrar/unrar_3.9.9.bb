DESCRIPTION = "RAR archivers"
HOMEPAGE = "http://www.rarlab.com/"
PR = "r0"

SRC_URI = "http://www.rarlab.com/rar/unrarsrc-${PV}.tar.gz;name=unrar \
		file://makefile.unix.patch;patch=1"
SRC_URI[unrar.md5sum] = "4271fc8710d299341c969666492b305c"
SRC_URI[unrar.sha256sum] = "460d4c014f5aaaa9b1c810dca180f07e155678b322169e20f4e51c616fa0e7ff"

S = "${WORKDIR}/unrar"

BBCLASSEXTEND = "native"
NATIVE_INSTALL_WORKS = "1"

EXTRA_OEMAKE = "-f makefile.unix DESTDIR=${D}${exec_prefix}"

do_compile() {
    oe_runmake
}

do_install() {
    oe_runmake install 
}
