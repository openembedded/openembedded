DESCRIPTION = "The MusicBrainz client is a library which can be built into other programs. \
It allows you to access the data held on the MusicBrainz server."

HOMEPAGE = "http://musicbrainz.org"
LICENSE = "LGPLv2.1+"

SRC_URI = "http://users.musicbrainz.org/~matt/libdiscid-${PV}.tar.gz"

inherit cmake pkgconfig


