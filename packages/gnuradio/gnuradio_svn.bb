DESCRIPTION = "GNU Radio"
SECTION =  "apps"
PRIORITY = "optional"
LICENSE = "GPL"
DEPENDS = "fftwf python boost cppunit sdcc-native swig swig-native"
RDEPENDS = "libfftwf python swig"

PV = "0.0+svn${SRCDATE}"
PR = "r0"


SRC_URI = "svn://gnuradio.org/svn/gnuradio;module=trunk;proto=http"

inherit autotools pkgconfig

S="${WORKDIR}/trunk"

CXXFLAGS_powerpc += "-lstdc++"

export BUILD_SYS := "${BUILD_SYS}"
export HOST_SYS := "${HOST_SYS}"

EXTRA_OECONF = "--disable-gr-atsc --disable-gr-video-sdl"

