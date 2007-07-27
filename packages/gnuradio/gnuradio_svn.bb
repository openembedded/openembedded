DESCRIPTION = "GNU Radio"
SECTION =  "apps"
PRIORITY = "optional"
LICENSE = "GPL"
DEPENDS = " guile-native fftwf python libusb virtual/libsdl alsa-lib jack boost cppunit sdcc-native swig-native"

RDEPENDS_${PN} = "python-core python-audio python-codecs python-lang python-textutils"

PV = "3.0.4+svn${SRCDATE}"
PR = "r2"

SRC_URI = "svn://gnuradio.org/svn/gnuradio;module=trunk;proto=http \
	   file://no-trellis-doc.patch;patch=1 \
	   "

inherit autotools pkgconfig

S="${WORKDIR}/trunk"

CXXFLAGS_powerpc += "-lstdc++"

export BUILD_SYS := "${BUILD_SYS}"
export HOST_SYS := "${HOST_SYS}"

EXTRA_OECONF = " \
                --disable-gr-atsc \
		--enable-gr-video-sdl \
		--enable-gr-audio-alsa  \
                --enable-gr-audio-jack \
                --enable-gr-audio-oss \
                --enable-mblock \
	        "

do_configure_append() {
        find ${S} -name Makefile | xargs sed -i s:'-I/usr/include':'-I${STAGING_INCDIR}':g
}

PACKAGES =+ "libusrp libusrp-inband libgromnithread libgnuradio-core libgnuradio-core-qa"
FILES_libusrp = "${libdir}/libusrp.so.*"
FILES_libusrp-inband = "${libdir}/libusrp_inband.so.*"
FILES_libgnuradio-core = "${libdir}/libgnuradio-core.so.*"
FILES_libgnuradio-core-qa = "${libdir}/libgnuradio-core-qa.so.*"
FILES_libgromnithread = "${libdir}/libgromnithread.so*"

FILES_${PN} += "${libdir}/python*/site-packages/gnuradio/*"
FILES_${PN}-dbg += "${libdir}/python*/site-packages/gnuradio/.debug \
                   ${libdir}/python*/site-packages/gnuradio/*/.debug \
		   "


