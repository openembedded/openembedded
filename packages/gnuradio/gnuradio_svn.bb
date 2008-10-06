require gnuradio.inc

DEFAULT_PREFERENCE = "-1"

PV = "3.1.3+svnr${SRCREV}"
PR = "r4"

EXTRA_OECONF += "--with-boost=${STAGING_DIR_TARGET}/usr CXXFLAGS=-DBOOST_SP_USE_PTHREADS --disable-usrp1 --disable--usrp2"

SRC_URI = "svn://gnuradio.org/svn/gnuradio/;module=trunk;proto=http \
    file://no-usrp2.patch;patch=1 \
#   file://no-trellis-doc.patch;patch=1 \
#           file://gnuradio-neon.patch;patch=1;pnum=0 \
	   "

S="${WORKDIR}/trunk"

#do_configure() {
#        ./bootstrap
#        oe_runconf
#}

do_compile_append() {
        sed -i -e s:${STAGING_DIR_TARGET}::g \
               -e s:/${TARGET_SYS}::g \
                  gnuradio-core/gnuradio-core.pc
}

