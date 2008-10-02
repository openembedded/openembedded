DESCRIPTION = "Squeak VM"
LICENSE = "Squeak License"
HOMEPAGE = "http://www.squeakvm.org"
DEPENDS = "virtual/libx11"

EXTRA_OECONF += " --with-x --without-npsqueak"


SRC_URI = "http://www.squeakvm.org/unix/release/Squeak-3.10-1.src.tar.gz \
           file://configure-fixes.patch;patch=1"
S = "${WORKDIR}/Squeak-3.10-1/platforms/unix/config"

inherit autotools

do_configure_prepend() {
    mkdir ${WORKDIR}/Squeak-3.10-1/platforms/unix/bld
    cd ${WORKDIR}/Squeak-3.10-1/platforms/unix/bld
}

do_compile_append() {
    cd ${WORKDIR}/Squeak-3.10-1/platforms/unix/bld
    find . -name 'Makefile' -exec sed -i s/@X_INCLUDES@//g {} \;
    find . -name 'Makefile' -exec sed -i s/@X_LIBS@//g {} \;
}

do_install_prepend() {
    cd ${WORKDIR}/Squeak-3.10-1/platforms/unix/bld
}
