DESCRIPTION = "Command-line (scriptable) Music Player Daemon (mpd) Client"
HOMEPAGE = "http://www.musicpd.org/mpc.shtml"
LICENSE = "GPLv2"
MAINTAINER = "Justin Patrin <papercrane@reversefold.com>"
SECTION = "console/multimedia"
PR = "r0"

SRC_URI = "http://mercury.chem.pitt.edu/~shank/mpc-${PV}.tar.gz"

inherit autotools
