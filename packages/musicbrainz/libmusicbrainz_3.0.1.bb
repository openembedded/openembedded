DEFAULT_PREFERENCE = "-1"

DESCRIPTION = "The MusicBrainz client is a library which can be built into other programs. \
It allows you to access the data held on the MusicBrainz server."
HOMEPAGE = "http://musicbrainz.org"
LICENSE = "LGPL"
DEPENDS = "expat neon"

SRC_URI = "http://ftp.musicbrainz.org/pub/musicbrainz/libmusicbrainz-${PV}.tar.gz"

inherit cmake pkgconfig

do_stage() {
	autotools_stage_all
}

