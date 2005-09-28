LICENSE = GPL
SECTION = "console/network"
DEPENDS = "jpeg libpng zlib tuxbox-plugins"
DESCRIPTION = "Dreambox plugin version of Links: Links is graphics and text mode WWW \
browser, similar to Lynx."
MAINTAINER = "Felix Domke <tmbinc@elitedvb.net>"

SRC_URI = "http://dreamboxupdate.com/sources-mirror/links-2.1pre15.tar.bz2 \
	   http://sources.dreamboxupdate.com/download/opendreambox/links-dream-2.1pre15/links-dream-plugin.diff;patch=1"

PACKAGES = "links-dream-plugin"

FILES_links-dream-plugin = "/usr/lib/tuxbox/plugins/links.* /etc/links/screen.config /etc/links/tables.tar.gz"

S = "${WORKDIR}/links-2.1pre15"

inherit autotools pkgconfig

bindir = "/usr/bin"
sbindir = "/usr/sbin"
