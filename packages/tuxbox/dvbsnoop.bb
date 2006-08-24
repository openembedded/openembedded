DEPENDS = "dreambox-dvbincludes"
DESCRIPTION = "DVBsnoop by rasc@users.sourceforge.net"
MAINTAINER = "Felix Domke <tmbinc@elitdvb.net>"

SRC_URI = "cvs://anoncvs@cvs.tuxbox.org/cvs/tuxbox;module=apps/dvb/dvbsnoop;method=ext \
           file://acinclude.m4"
	   
SRCDATE = "20060405"
PR = "r0"
PV = "0.0+cvs${SRCDATE}"
S = "${WORKDIR}/dvbsnoop"

inherit autotools pkgconfig

bindir = "/usr/bin"
sbindir = "/usr/sbin"

EXTRA_OECONF = "--with-target=cdk"
