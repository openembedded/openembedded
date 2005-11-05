DESCRIPTION="The Astersisk open source software PBX"
HOMEPAGE="www.asterisk.org"
LICENSE="GPL"
DEPENDS="ncurses zlib openssl"

SRC_URI="http://ftp.digium.com/pub/asterisk/asterisk-${PV}.tar.gz \
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
