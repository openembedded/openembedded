require gnuradio.inc

DEPENDS += " gsl "

PR = "${INC_PR}.1"

S = "${WORKDIR}/gnuradio-3.2.1"

EXTRA_OECONF += "--with-boost=${STAGING_DIR_TARGET}/usr CXXFLAGS=-DBOOST_SP_USE_PTHREADS --disable--usrp2"

SRC_URI = "ftp://ftp.gnu.org/gnu/gnuradio/gnuradio-3.2.1.tar.gz \
    file://no-usrp2.patch;patch=1 \
    file://gnuradio-neon.patch;patch=1;pnum=0 \
     ${SOURCEFORGE_MIRROR}/libusb/libusb-0.1.12.tar.gz \
"

do_compile_append() {
        sed -i -e s:${STAGING_DIR_TARGET}::g \
               -e s:/${TARGET_SYS}::g \
                  gnuradio-core/gnuradio-core.pc
}

