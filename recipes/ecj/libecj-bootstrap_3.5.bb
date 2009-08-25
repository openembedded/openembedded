# Causes problems with openjdk/icedtea. See Eclipse bug eclipse bug #285466
# Might get fixed in IcedTea 1.6
DEFAULT_PREFERENCE = "-1"

require libecj-bootstrap.inc

PR = "r0"

SRC_URI = " \
	   http://mirrors.ibiblio.org/pub/mirrors/eclipse/eclipse/downloads/drops/R-3.5-200906111540/ecjsrc-3.5.zip \
          "

