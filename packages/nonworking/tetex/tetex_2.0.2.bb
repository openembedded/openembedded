SRC_URI = ftp://cam.ctan.org/tex-archive/systems/unix/teTeX/2.0/distrib/tetex-src-${PV}.tar.gz \
	  file://${FILESDIR}/configure.patch;patch=1
S = ${WORKDIR}/tetex-src-${PV}

inherit autotools

do_configure () {
	sh ./reautoconf
	oe_runconf
}
