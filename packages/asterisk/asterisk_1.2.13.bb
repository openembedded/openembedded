DESCRIPTION="The Asterisk open source software PBX"
HOMEPAGE="www.asterisk.org"
LICENSE="GPL"
DEPENDS="ncurses zlib openssl curl alsa-lib libogg libvorbis popt"
PR = "r1"

SRC_URI="http://ftp.digium.com/pub/asterisk/releases/asterisk-${PV}.tar.gz \
	 file://uclibc-compat-getloadavg.patch;patch=1 \
	 file://uclibc-dsn.patch;patch=1 \
         file://asterisk.patch;patch=1"


export CROSS_COMPILE="${CCACHE}${HOST_PREFIX}"
export CROSS_COMPILE_BIN="${STAGING_BINDIR}"
export CROSS_COMPILE_TARGET="${STAGING_DIR}/${HOST_SYS}"

export CROSS_ARCH="Linux"
export CROSS_PROC="arm"
export SUB_PROC="xscale"

export MAKECMDGOALS="dont-optimize"

# We will probably have to edit the CFLAG in the Makefile

do_compile() {
        oe_runmake
}

do_install() {
        oe_runmake DESTDIR=${D} install
}

do_stage () {
        install -d ${STAGING_INCDIR}/asterisk
        install -m 0644 ${S}/include/asterisk/*.h ${STAGING_INCDIR}/asterisk/
}


