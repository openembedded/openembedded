LICENSE = "GPL"
SECTION = "base"
MAINTAINER = "Inge Arnesen <inge.arnesen@gmail.com>"
DESCRIPTION = "The man page suite, including man, apropos, \
and whatis consists of programs that are used to read most \
of the documentation available on a Linux system."
PR = "r1"
RDEPENDS="less groff"
# Note: The default man.conf uses wrong names for GNU eqn and troff,
# so we install our own
SRC_URI = "ftp://ftp.kernel.org/pub/linux/utils/man/man-${PV}.tar.bz2 \
		file://man.conf"

EXTRA_OEMAKE = ""
GS = "-DGREPSILENT=\"q\""
DEFS = "-DUSG -DDO_COMPRESS ${GS}"

do_configure() {
	# this doesn't support cross compilation, so it generates a
	# bogus configuration
	./configure -d -confdir ${sysconfdir}
}

do_compile() {
	# this fixes up the cross compilation by killing the bogus DEFS
	(cd src; ${BUILD_CC} ${BUILD_CFLAGS} ${BUILD_LDFLAGS} \
		makemsg.c -o makemsg)
	oe_runmake 'DEFS=${DEFS}'
}

do_install() {
	oe_runmake 'PREFIX=${D}' 'DEFS=${DEFS}' install
	install -m 644 ${FILESDIR}/man.conf ${D}/etc
}

FILES_${PN} = "${bindir} ${sbindir} ${libexecdir} ${libdir}/lib*.so.* \
	       ${libdir}/*/ ${sysconfdir} ${sharedstatedir} ${localstatedir} \
	       /bin /sbin /lib/*/ /lib/*.so*"
