require forte.inc

PR = "r1"

DEFAULT_PREFERENCE_oxnas = "1"
DEFAULT_PREFERENCE_hipox = "1"

SRC_URI = "http://kent.dl.sourceforge.net/sourceforge/fordiac/forte-0.3.zip \
	file://forte-0.3-patch_20081008.diff;patch=1"

S="${WORKDIR}/forte-${PV}"
