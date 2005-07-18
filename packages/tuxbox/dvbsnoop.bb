DEPENDS = "dreambox-dvbincludes"
DESCRIPTION = "DVBsnoop by rasc@users.sourceforge.net"
MAINTAINER = "Felix Domke <tmbinc@elitdvb.net>"

SRC_URI = "cvs://anoncvs@cvs.tuxbox.org/cvs/tuxbox;module=apps/dvb/dvbsnoop;method=ext \
           file://acinclude.m4"
	   
CVSDATE = "20050609"
PR = "r0"
S = "${WORKDIR}/dvbsnoop"

inherit autotools pkgconfig

bindir = "/usr/bin"
sbindir = "/usr/sbin"

EXTRA_OECONF = "--with-target=cdk"
