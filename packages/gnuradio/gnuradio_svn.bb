DESCRIPTION = "GNU Radio"
SECTION =  "apps"
PRIORITY = "optional"
LICENSE = "GPL"
DEPENDS = "fftwf python boost cppunit sdcc-native swig swig-native"

RDEPENDS_${PN} = "python-core python-audio python-codecs python-lang python-textutils swig"

PV = "3.0.4+svn${SRCDATE}"
PR = "r1"


SRC_URI = "svn://gnuradio.org/svn/gnuradio;module=trunk;proto=http \
	   file://no-trellis-doc.patch;patch=1 \
	   "

inherit autotools pkgconfig

S="${WORKDIR}/trunk"

CXXFLAGS_powerpc += "-lstdc++"

export BUILD_SYS := "${BUILD_SYS}"
export HOST_SYS := "${HOST_SYS}"

EXTRA_OECONF = "--disable-gr-atsc --disable-gr-video-sdl"

PACKAGES =+ "libgromnithread libgnuradio-core libgnuradio-core-qa"
FILES_libgnuradio-core = "${libdir}/libgnuradio-core.so.*"
FILES_libgnuradio-core-qa = "${libdir}/libgnuradio-core-qa.so.*"
FILES_libgromnithread = "${libdir}/libgromnithread.so*"

FILES_${PN} += "${libdir}/python*/site-packages/gnuradio/*"
FILES_${PN}-dbg += "${libdir}/python*/site-packages/gnuradio/.debug \
                   ${libdir}/python*/site-packages/gnuradio/*/.debug \
		   "


