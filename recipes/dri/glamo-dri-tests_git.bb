DEPENDS = "libdrm virtual/libx11 libxext"

SRCREV = "062cc7ef88078815fc2f8d0da3abd80d0514c248"
PV = "1.0.0+gitr${SRCPV}"
PR = "r1"

SRC_URI = "git://git.bitwiz.org.uk/glamo-dri-tests.git;protocol=git;branch=master"

inherit pkgconfig

do_compile_prepend() {
	export CROSS_CFLAGS="`pkg-config --cflags libdrm_glamo`"
	export CC="${CC} ${LDFLAGS}"
}

do_install() {
        PREFIX=${D}/usr oe_runmake install
}

S = "${WORKDIR}/git"
