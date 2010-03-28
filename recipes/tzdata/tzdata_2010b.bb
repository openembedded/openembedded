require tzdata.inc

SRC_URI = "http://ftp.uni-erlangen.de/pub/Linux/MIRROR.gentoo/distfiles/tzdata${PV}.tar.gz \
	file://russia-2010.diff;patch=1"
PR = "${INC_PR}.1"
