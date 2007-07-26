DESCRIPTION = "GNU Radio"
SECTION =  "apps"
PRIORITY = "optional"
LICENSE = "GPL"
DEPENDS = "fftw python boost cppunit sdcc-native swig swig-native"
RDEPENDS = "fftw python swig"
PR = "r0"

SRC_URI = "svn://gnuradio.org/svn/gnuradio;module=trunk;proto=http"

inherit autotools pkgconfig

S="${WORKDIR}/trunk"

CXXFLAGS_powerpc += "-lstdc++"

export BUILD_SYS := "${BUILD_SYS}"
export HOST_SYS := "${HOST_SYS}"

EXTRA_OECONF = "--disable-gr-atsc --disable-gr-video-sdl"

