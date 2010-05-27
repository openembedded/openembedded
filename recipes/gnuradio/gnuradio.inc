DESCRIPTION = "GNU Radio"
SECTION =  "apps"
PRIORITY = "optional"
LICENSE = "GPLv3"
DEPENDS = "virtual/libusb0 guile-native fftwf python virtual/libsdl alsa-lib jack boost cppunit sdcc-native swig-native python-numpy"
INC_PR = "r7"

inherit distutils-base autotools autotools_stage pkgconfig

export BUILD_SYS
export HOST_SYS=${MULTIMACH_TARGET_SYS}

CXXFLAGS_powerpc += "-lstdc++"

EXTRA_OECONF = " \
  --program-prefix= \
  --disable-gr-atsc \
  --enable-gr-video-sdl \
  --enable-gr-audio-alsa  \
  --enable-gr-audio-jack \
  --enable-gr-audio-oss \
  --enable-mblock \
  --disable-html-docs \
  --with-pythondir=${PYTHON_SITEPACKAGES_DIR} \
  PYTHON_CPPFLAGS=-I${STAGING_INCDIR}/${PYTHON_DIR} \
"

#export USB_CFLAGS="-I${STAGING_INCDIR}"
#export USB_LIBS="-L${STAGING_LIBDIR}"

do_configure_prepend() {
	if [ -e ${WORKDIR}/acinclude.m4 ] ; then
		cp ${WORKDIR}/acinclude.m4 ${S}
	fi
}

do_configure_append() {
	find ${S} -name Makefile | xargs sed -i s:'-I/usr/include':'-I${STAGING_INCDIR}':g
	find ${S} -name Makefile | xargs sed -i s:' /usr/include':' ${STAGING_INCDIR}':g
}

do_stage() {
	autotools_stage_all
	sed -i s,-l:libusb-gnur.a,,g ${STAGING_LIBDIR}/libusrp.la
}

RDEPENDS_${PN} = "python-core python-audio python-threading python-codecs python-lang python-textutils \
                  python-shell python-pickle python-compiler python-pkgutil python-pydoc python-mmap \
                  python-netclient python-unittest python-difflib python-pprint python-numpy \
"

RDEPENDS_gnuradio-usrp = "python-core"

PACKAGES =+ "\
  libpmt libpmt-qa \
  libmblock libmblock-qa \
  libgr-audio-alsa libgr-audio-oss libgr-audio-jack\
  libusrp libusrp-inband libusrp-inband-qa \
  libgromnithread \
  libgnuradio-core libgnuradio-core-qa \
  gnuradio-usrp-dbg gnuradio-usrp gnuradio-examples \
"

FILES_gnuradio-examples = "${datadir}/gnuradio/examples"

FILES_libpmt = "${libdir}/libpmt.so"
FILES_libpmt-qa = "${libdir}/libpmt-qa.so"
FILES_libmblock = "${libdir}/libmblock.so"
FILES_libmblock-qa = "${libdir}/libmblock-qa.so"
FILES_libgr-audio-alsa = "${libdir}/libgr_audio_alsa.so ${sysconfdir}/gnuradio/conf.d/gr-audio-alsa.conf"
FILES_libgr-audio-oss = "${libdir}/libgr_audio_oss.so ${sysconfdir}/gnuradio/conf.d/gr-audio-oss.conf"
FILES_libgr-audio-jack = "${libdir}/libgr_audio_jack.so ${sysconfdir}/gnuradio/conf.d/gr-audio-jack.conf"


FILES_libusrp = "${libdir}/libusrp.so.*"
FILES_libusrp-inband = "${libdir}/libusrp_inband.so.*"
FILES_libusrp-inband-qa = "${libdir}/libusrp_inband-qa.so"
FILES_libgnuradio-core = "${libdir}/libgnuradio-core.so.* ${sysconfdir}/gnuradio/conf.d/*core*"
FILES_libgnuradio-core-qa = "${libdir}/libgnuradio-core-qa.so.*"
FILES_libgromnithread = "${libdir}/libgromnithread.so*"

FILES_${PN} += "${PYTHON_SITEPACKAGES_DIR}/gnuradio/*"
FILES_${PN}-dbg += "${PYTHON_SITEPACKAGES_DIR}/gnuradio/.debug \
                    ${PYTHON_SITEPACKAGES_DIR}/gnuradio/*/.debug \
		   "

FILES_gnuradio-usrp = "${PYTHON_SITEPACKAGES_DIR}/usrp/* \
                       ${bindir}/usrp* \
                       ${datadir}/usrp/*/*"
FILES_gnuradio-usrp-dbg = "${PYTHON_SITEPACKAGES_DIR}/usrp/.debug"
