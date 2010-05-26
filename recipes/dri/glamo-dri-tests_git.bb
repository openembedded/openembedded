DEPENDS = "libdrm virtual/libx11 libxext"

SRCREV = "e72583b8699f10f7b9a29066a09ad974a8f5cd1b"
PV = "1.0.0+gitr${SRCPV}"

SRC_URI = "git://git.bitwiz.org.uk/glamo-dri-tests.git;protocol=git;branch=master"

inherit pkgconfig

do_compile_prepend() {
	export CROSS_CFLAGS=`pkg-config --cflags libdrm_glamo`
}

do_install() {
        PREFIX=${D}/usr make install
}

S = "${WORKDIR}/git"
