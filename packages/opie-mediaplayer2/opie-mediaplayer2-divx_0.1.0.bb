DESCRIPTION = "OPIE Mediaplayer DIVX pseudo package."
MAINTAINER = "Werner Schulte <w1@schulte-ac.de>"
LICENSE = "GPL"
ALLOW_EMPTY = "1"
PACKAGES = "${PN}"
PACKAGE_ARCH = "all"

DEPENDS = "opie-mediaplayer2 \
	   opie-mediaplayer2-skin-default \
	   libxine-opie "

RDEPENDS = "opie-mediaplayer2 \
	   opie-mediaplayer2-skin-default \
	   libxine-plugin-ao-out-oss \
	   libxine-plugin-decode-ff \
	   libxine-plugin-decode-mad \
	   libxine-plugin-dmx-audio \
	   libxine-plugin-dmx-avi \
	   libxine-plugin-dmx-mpeg \
	   libxine-plugin-inp-file \
	   libxine1"

