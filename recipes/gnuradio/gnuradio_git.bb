require gnuradio.inc

DEFAULT_PREFERENCE = "-1"

DEPENDS += " gsl "

#SRCREV = "0cd478fdc090123e09b7ee21c88e5657abab8ae0"

SRCREV = "bf7ad4d17514aba9fc5209bc916ce37482f77eaa"

PR = "${INC_PR}.2"
PV = "3.2.1-${PR}+gitr${SRCREV}"

EXTRA_OECONF += "--with-boost=${STAGING_DIR_TARGET}/usr CXXFLAGS=-DBOOST_SP_USE_PTHREADS --disable-usrp2 --disable-usrp2-firmware --with-fusb-tech=libusb1"

# Make it easy to test against developer repos and branches
GIT_REPO = "balister.git"
GIT_BRANCH = "omap3-build"

SRC_URI = "git://gnuradio.org/git/${GIT_REPO};branch=${GIT_BRANCH};protocol=http \
     ${SOURCEFORGE_MIRROR}/libusb/libusb-0.1.12.tar.gz \
"

S="${WORKDIR}/git"

do_compile_append() {
        sed -i -e s:${STAGING_DIR_TARGET}::g \
               -e s:/${TARGET_SYS}::g \
                  gnuradio-core/gnuradio-core.pc
}

