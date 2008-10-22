# Copyright (c) 2008, Ovidiu Sas - VoIP Embedded Inc., All Rights Reserved
# Released under the MIT license (see packages/COPYING)
DESCRIPTION = "The Asterisk open source software PBX"
HOMEPAGE = "http://www.asterisk.org"
SECTION = "voip"
LICENSE = "GPLv2"
PRIORITY = "optional"
SECTION = "console/telephony"
DEPENDS = "asterisk openssl curl"
PR = "r1"

DEFAULT_PREFERENCE = "-1"

SRC_URI="http://downloads.digium.com/pub/asterisk/asterisk-addons-${PV}.tar.gz"

ARCH_efika="ppc"
ARCH_dht-walnut="ppc"
ARCH_magicbox="ppc"
ARCH_sequoia="ppc"


inherit autotools

EXTRA_OECONF =  "--with-ssl=${STAGING_EXECPREFIXDIR}\
		--with-termcap=${STAGING_EXECPREFIXDIR}\
		--with-curl=${STAGING_EXECPREFIXDIR}\
		--without-curses\
		--with-ncurses=${STAGING_EXECPREFIXDIR}\
		--without-mysqlclient\
		--with-h323\
		"

#export NOISY_BUILD=yes

export ASTCFLAGS = "-fsigned-char -I${STAGING_INCDIR} -DPATH_MAX=4096"
export ASTLDFLAGS="${LDFLAGS} -lpthread -ldl -lresolv "
export PROC="${ARCH}"

do_configure () {
	# Looks like rebuilding configure doesn't work, so we are skipping
	# that and are just using the shipped one
	gnu-configize
	libtoolize --force
	oe_runconf
}

do_compile() {
	(
	#make sure that menuselect gets build using host toolchain
	unset CC LD CXX CCLD CFLAGS CPPFLAGS LDFLAGS CXXFLAGS
	cd menuselect 
	./configure
	oe_runmake
	cd ../
	) || exit 1
	oe_runmake
}

CONFFILES_${PN} += "${sysconfdir}/asterisk/mobile.conf"
CONFFILES_${PN} += "${sysconfdir}/asterisk/res_mysql.conf"
CONFFILES_${PN} += "${sysconfdir}/asterisk/ooh323.conf"
CONFFILES_${PN} += "${sysconfdir}/asterisk/cdr_mysql.conf"

