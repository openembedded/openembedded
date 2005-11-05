LICENSE = "GPL"
SECTION = "base"
DESCRIPTION = "The man page suite, including man, apropos, \
and whatis consists of programs that are used to read most \
of the documentation available on a Linux system."

SRC_URI = "ftp://ftp.kernel.org/pub/linux/utils/man/man-${PV}.tar.bz2"

EXTRA_OEMAKE = ""
GS = "-DGREPSILENT=\"q\""
DEFS = "-DUSG -DDO_COMPRESS ${GS}"

do_configure() {
	./configure -d -confdir ${sysconfdir}
}

do_compile() {
	(cd src; ${BUILD_CC} ${BUILD_CFLAGS} ${BUILD_LDFLAGS} \
		makemsg.c -o makemsg)
	oe_runmake 'DEFS=${DEFS}'
}

do_install() {
	oe_runmake 'PREFIX=${D}' install
}

FILES_${PN} = "${bindir} ${sbindir} ${libexecdir} ${libdir}/lib*.so.* \
	       ${libdir}/*/ ${sysconfdir} ${sharedstatedir} ${localstatedir} \
	       /bin /sbin /lib/*/ /lib/*.so*"
