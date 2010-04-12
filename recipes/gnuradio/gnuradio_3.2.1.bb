require gnuradio-libusb-compat.inc

DEPENDS += " gsl "

PR = "${INC_PR}.1"

S = "${WORKDIR}/gnuradio-3.2.1"

EXTRA_OECONF += "--with-boost=${STAGING_DIR_TARGET}/usr CXXFLAGS=-DBOOST_SP_USE_PTHREADS --disable--usrp2"

SRC_URI = "ftp://ftp.gnu.org/gnu/gnuradio/gnuradio-3.2.1.tar.gz;name=archive \
    file://no-usrp2.patch;patch=1 \
    file://gnuradio-neon.patch;patch=1;pnum=0 \
     ${SOURCEFORGE_MIRROR}/libusb/libusb-0.1.12.tar.gz;name=libusb \
"

do_compile_append() {
        sed -i -e s:${STAGING_DIR_TARGET}::g \
               -e s:/${TARGET_SYS}::g \
                  gnuradio-core/gnuradio-core.pc
}


SRC_URI[archive.md5sum] = "f0721c5dce7cb02c75ac4e7bb9cc0ec9"
SRC_URI[archive.sha256sum] = "a12b0fcd08508a85ee7ec7003ec0f3418378d479304ce85e8453d46bacc0ce9f"
SRC_URI[libusb.md5sum] = "caf182cbc7565dac0fd72155919672e6"
SRC_URI[libusb.sha256sum] = "37f6f7d9de74196eb5fc0bbe0aea9b5c939de7f500acba3af6fd643f3b538b44"
