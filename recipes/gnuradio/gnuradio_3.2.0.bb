require gnuradio.inc

DEPENDS += " gsl "

PR = "r0"

S = "${WORKDIR}/gnuradio-3.2"

EXTRA_OECONF += "--with-boost=${STAGING_DIR_TARGET}/usr CXXFLAGS=-DBOOST_SP_USE_PTHREADS --disable--usrp2"

SRC_URI = "ftp://ftp.gnu.org/gnu/gnuradio/gnuradio-3.2.tar.gz \
    file://no-usrp2.patch;patch=1 \
    file://gnuradio-neon.patch;patch=1;pnum=0 \
     ${SOURCEFORGE_MIRROR}/libusb/libusb-0.1.12.tar.gz \
"

# This is an awful hack to allow GNU Radio to use libusb-0.12, regardless
# of what is used by the rest of OE

addtask buildlibusb before do_configure after do_unpack

do_buildlibusb[deptask] = "do_populate_staging"

do_compile_append() {
        sed -i -e s:${STAGING_DIR_TARGET}::g \
               -e s:/${TARGET_SYS}::g \
                  gnuradio-core/gnuradio-core.pc
}

