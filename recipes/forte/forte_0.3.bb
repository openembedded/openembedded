require forte.inc

PR = "r1"

DEFAULT_PREFERENCE_oxnas = "1"
DEFAULT_PREFERENCE_hipox = "1"

SRC_URI = "http://kent.dl.sourceforge.net/sourceforge/fordiac/forte-0.3.zip \
	file://forte-0.3-patch_20081008.diff;patch=1"

S="${WORKDIR}/forte-${PV}"

SRC_URI[md5sum] = "2d01a3d3b9b16bf646e6bb89cb9b0faf"
SRC_URI[sha256sum] = "c3a61174f6a69252983a9b26ea87005bcab6a72b0bd34ea693e3de89e70eaea6"
