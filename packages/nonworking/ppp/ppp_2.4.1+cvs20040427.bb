DESCRIPTION = "Point-to-Point Protocol (PPP) daemon"

DEPENDS = "libpcap-0.7.2 openssl"

PACKAGES =+ "${PN}-plugins"

FILES_${PN}-plugins = /usr/lib/pppd/*

SRC_URI = "http://handhelds.org/~zecke/downloads/tmp/ppp-cvs-20040427.tar.gz \
	  file://008_pathnames.h.diff;patch=1 \
	  file://011_scripts_redialer.diff;patch=1 \
	  file://018_ip-up_option.diff;patch=1 \
	  file://057_pppoe-interface-change;patch=1 \
	  file://auth_hook_segfault;patch=1 \
	  file://cifdefroute.dif;patch=1 \
	  file://close_devfd;patch=1 \
	  file://fix_closed_fds;patch=1 \
	  file://no_crypt_hack;patch=1 \
	  file://ppp-2.3.11-oedod.dif;patch=1 \
	  file://ppp-2.4.2-stripMSdomain;patch=1 \
	  file://pppdump-no-deflate;patch=1 \
	  file://pppoe_discovery;patch=1 \
	  file://setevn_call_file;patch=1 \
	  file://syslog_local2;patch=1 \
	  file://use_openssl;patch=1 \
	  file://install_and_cc.patch;patch=1 \
	  file://mppe-signed.patch;patch=1 "

S = "${WORKDIR}/ppp"

inherit autotools

EXTRA_OEMAKE = "STRIPPROG=arm-linux-strip"
EXTRA_OECONF = --disable-strip

