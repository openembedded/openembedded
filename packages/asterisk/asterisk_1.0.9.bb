DESCRIPTION="The Astersisk open source software PBX"
HOMEPAGE="www.asterisk.org"
LICENSE="GPL"
DEPENDS="ncurses zlib openssl"
PR = "r2"

SRC_URI="http://ftp.digium.com/pub/asterisk/releases/asterisk-${PV}.tar.gz \
	 file://gsm.patch;patch=1 \
         file://makefile.patch;patch=1"


# Doh - they use 'L'inux intead of linux
# FIXME:  Do the sed here

export OSARCH="Linux"
export PROC="${TARGET_ARCH}"

# We will probably have to edit the CFLAG in teh Makefile

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


