DESCRIPTION = "Open-source tools and libraries for data acquisition"
HOMEPAGE = "http://www.comedi.org/"
SECTION = "devel/libs"
LICENSE = "GPLv2"

SRC_URI = "http://www.comedi.org/download/comedilib-${PV}.tar.gz;name=src"
SRC_URI[src.md5sum] = "992dbdf14590a7c9ea8dd83752e731b4"
SRC_URI[src.sha256sum] = "56c5d27b57924778fae6aac3e776dfebcbb9f6eed79c39b6e0b4ad162d86bef8"

inherit autotools

