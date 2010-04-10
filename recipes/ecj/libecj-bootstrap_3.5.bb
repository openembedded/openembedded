# Causes problems with openjdk/icedtea. See Eclipse bug eclipse bug #285466
# Might get fixed in IcedTea 1.6
DEFAULT_PREFERENCE = "-1"

require libecj-bootstrap.inc

PR = "r1"

SRC_URI = " \
	   http://mirrors.ibiblio.org/pub/mirrors/eclipse/eclipse/downloads/drops/R-3.5-200906111540/ecjsrc-3.5.zip \
          "


SRC_URI[md5sum] = "356f1d337833670e34cf53b58513daeb"
SRC_URI[sha256sum] = "f3f82d0b91f63fa3aab52f61ad8f5d50c0e4029479cf4b720b83a3424074bd38"
