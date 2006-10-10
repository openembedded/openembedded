SECTION = "console/network"
DESCRIPTION = "A small and simple WikiWikiWeb implementation written in C \
and which includes a built in webserver."
LICENSE = "GPLv2"

SRC_URI = "http://didiwiki.org/sources/didiwiki-${PV}.tar.gz"
S = "${WORKDIR}/didiwiki-${PV}"

inherit autotools
