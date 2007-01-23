DESCRIPTION = "Command-line (scriptable) Music Player Daemon (mpd) Client"
HOMEPAGE = "http://www.musicpd.org/mpc.shtml"
LICENSE = "GPLv2"
MAINTAINER = "Justin Patrin <papercrane@reversefold.com>"
SECTION = "console/multimedia"
PR = "r0"

DEFAULT_PREFERENCE = "-1"

SRC_URI = "http://musicpd.org/uploads/files/mpc-${PV}.tar.gz"

inherit autotools
