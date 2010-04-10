require qpf.inc

DESCRIPTION = "Arabic fonts from Arabeyes.org"
HOMEPAGE = "http://www.arabeyes.org"
LICENSE = "GPL"
PR = "r1"

SRC_URI = "${SOURCEFORGE_MIRROR}/arabeyes/arabic-fonts-${PV}.tar.gz"
S = "${WORKDIR}"

SRC_URI[md5sum] = "c6b1aa28bfecdd0c693a2afc43d7679e"
SRC_URI[sha256sum] = "d5b93fb8dbfa73e4a542bb8ad7d61c8b48dcf79948da26da9e9ef3b1a49c4221"
