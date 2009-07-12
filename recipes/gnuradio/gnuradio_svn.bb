require gnuradio.inc

DEFAULT_PREFERENCE = "-1"

DEPENDS += " gsl "

PV = "3.2.1+svnr${SRCREV}"
PR = "${INC_PR}.1"

EXTRA_OECONF += "--with-boost=${STAGING_DIR_TARGET}/usr CXXFLAGS=-DBOOST_SP_USE_PTHREADS --disable--usrp2"

SRC_URI = "svn://gnuradio.org/svn/gnuradio/;module=trunk;proto=http \
    file://no-usrp2-svn.patch;patch=1 \
     ${SOURCEFORGE_MIRROR}/libusb/libusb-0.1.12.tar.gz \
"

S="${WORKDIR}/trunk"

do_compile_append() {
        sed -i -e s:${STAGING_DIR_TARGET}::g \
               -e s:/${TARGET_SYS}::g \
                  gnuradio-core/gnuradio-core.pc
}

