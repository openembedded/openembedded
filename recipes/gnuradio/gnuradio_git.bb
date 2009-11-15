require gnuradio.inc

#DEFAULT_PREFERENCE = "-1"

DEPENDS += " gsl "

SRCREV = "0cd478fdc090123e09b7ee21c88e5657abab8ae0"
#SRCREV = "0f4226088ba84e25139bf77957c80ca7a64cba11"
PR = "${INC_PR}.1"
PV = "3.2.1-${PR}+gitr${SRCPV}"
PE = "1"

EXTRA_OECONF += "--with-boost=${STAGING_DIR_TARGET}/usr CXXFLAGS=-DBOOST_SP_USE_PTHREADS --disable-usrp2 --disable-usrp2-firmware --with-fusb-tech=libusb1"

SRC_URI = "git://gnuradio.org/git/gnuradio.git;protocol=http \
     ${SOURCEFORGE_MIRROR}/libusb/libusb-0.1.12.tar.gz \
"

S="${WORKDIR}/git"

do_compile_append() {
        sed -i -e s:${STAGING_DIR_TARGET}::g \
               -e s:/${TARGET_SYS}::g \
                  gnuradio-core/gnuradio-core.pc
}

