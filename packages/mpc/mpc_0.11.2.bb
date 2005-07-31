SECTION = "console/multimedia"
DESCRIPTION = "command line client for mpd"
HOMEPAGE = "http://www.musicpd.org/mpc.shtml"
LICENSE = "GPLv2"
MAINTAINER = "Hannes Reich <hannes@skynet.ie>"
DEPENDS = ""
PR = "r0"

SRC_URI = "http://mercury.chem.pitt.edu/~shank/mpc-${PV}.tar.gz \
	file://configure-searchdirs.patch;patch=1"

inherit autotools



