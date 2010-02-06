LICENSE = "GPL"
SECTION = "base"
DESCRIPTION = "The man page suite, including man, apropos, \
and whatis consists of programs that are used to read most \
of the documentation available on a Linux system."
PR = "r5"
RDEPENDS_${PN} = "less groff"

# Note: The default man.conf uses wrong names for GNU eqn and troff,
# so we install our own
SRC_URI = "${KERNELORG_MIRROR}/pub/linux/utils/man/man-${PV}.tar.bz2 \
		file://man.conf"

# Disable parallel make or it tries to link objects before they are built
PARALLEL_MAKE = ""

EXTRA_OEMAKE = 'LDFLAGS="${LDFLAGS}"'
GS = "-DGREPSILENT=\"q\""
DEFS = "-DUSG -DDO_COMPRESS ${GS}"

do_configure() {
	# this doesn't support cross compilation, so it generates a
	# bogus configuration
	sed -i /^LDFLAGS/d src/Makefile.in
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
	install -m 644 ${WORKDIR}/man.conf ${D}/etc
}

FILES_${PN} = "${bindir}/* ${sbindir} ${libexecdir} ${libdir}/lib*.so.* \
	       ${libdir}/*/ ${sysconfdir} ${sharedstatedir} ${localstatedir} \
	       /bin /sbin /lib/*/ /lib/*.so*"
