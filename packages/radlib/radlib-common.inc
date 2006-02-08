SECTION = "libs"
LICENSE = "BSD"
DESCRIPTION = "radlib is a rapid application development library for unix interprocess communications, sockets, SHA utilities, CRC utilities and much more."
MAINTAINER = "Mark Teel (mark@teel.ws)"
HOMEPAGE = "http://www.radlib.teel.ws/"

SRC_URI = "${SOURCEFORGE_MIRROR}/radlib/radlib-${PV}.tar.gz"

S = "${WORKDIR}/radlib-${PV}"

inherit autotools 
do_compile_prepend() {
	rm -f ${STAGING_LIBDIR}/librad.a
	rm -f ${STAGING_LIBDIR}/librad.la  
	rm -f ${STAGING_LIBDIR}/librad.so
	rm -f ${STAGING_LIBDIR}/librad.so.0
	rm -f ${STAGING_LIBDIR}/librad.so.0.0.0
}

headers =       "radbuffers.h \
                radconffile.h \
                radcrc.h \
                raddebug.h \
                radevents.h \
                radlist.h \
                radmsgLog.h \
                radmsgRouter.h \
                radprocess.h \
                radproclist.h \
                radprocutils.h \
                radqueue.h \
                radsemaphores.h \
                radsha.h \
                radshmem.h \
                radsocket.h \
                radsortlist.h \
                radstack.h \
                radstates.h \
                radsysdefs.h \
                radsystem.h \
                radsysutils.h \
                radtimers.h \
                radtimeUtils.h \
                raddatabase.h \
                radUDPsocket.h"

do_stage () {
        cd ${S}/src/.libs

        oe_libinstall -so -a librad ${STAGING_LIBDIR}/
        cd ${S}/h
        for i in ${headers}; do
                install -m 0644 $i ${STAGING_INCDIR}/
        done
        cd ${S}
}


