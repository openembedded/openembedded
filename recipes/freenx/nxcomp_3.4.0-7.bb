LICENSE = "GPL"

SRC_URI = "http://64.34.161.181/download/3.4.0/sources/${PN}-${PV}.tar.gz \
           "

SRC_URI[md5sum] = "cba926f2b855231a8fc3e0dabff52855"
SRC_URI[sha256sum] = "1c9eb63e46ae263899aec08c017c6af93b0632883ec916d465df9e438229e485"

S = "${WORKDIR}/${PN}"

inherit autotools

do_install () {
        oe_runmake "bindir=${D}${bindir}" \
                   "man1dir=${D}${mandir}" \
                   install
	install -p ${S}/MD5.h ${STAGING_INCDIR}/MD5.h
	install -p ${S}/NXalert.h ${STAGING_INCDIR}/NXalert.h
	install -p ${S}/NX.h ${STAGING_INCDIR}/NX.h
	install -p ${S}/NXmitshm.h ${STAGING_INCDIR}/NXmitshm.h
	install -p ${S}/NXpack.h ${STAGING_INCDIR}/NXpack.h
	install -p ${S}/NXproto.h ${STAGING_INCDIR}/NXproto.h
	install -p ${S}/NXrender.h ${STAGING_INCDIR}/NXrender.h
	install -p ${S}/NXvars.h ${STAGING_INCDIR}/NXvars.h
	install -p ${S}/libXcomp* ${STAGING_LIBDIR}
}
