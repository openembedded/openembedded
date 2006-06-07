DESCRIPTION="The Astersisk open source software PBX"
HOMEPAGE="www.asterisk.org"
LICENSE="GPL"
DEPENDS="ncurses zlib openssl curl"
PR = "r0"

SRC_URI="http://ftp.digium.com/pub/asterisk/releases/asterisk-${PV}.tar.gz \
         file://makefile.patch;patch=1"


# Doh - they use 'L'inux intead of linux
# FIXME:  Do the sed here

export OSARCH="Linux"
export PROC="${TARGET_ARCH}"

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


