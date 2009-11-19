DEPENDS = "libdrm virtual/libx11 libxext"

PV = "1.0.0+gitr${SRCREV}"

SRC_URI = "git://git.bitwiz.org.uk/glamo-dri-tests.git;protocol=git;branch=master"

inherit pkgconfig

do_compile_prepend() {
	export CROSS_CFLAGS=`pkg-config --cflags libdrm_glamo`
}

do_install() {
        PREFIX=${D}/usr make install
}

S = "${WORKDIR}/git"
