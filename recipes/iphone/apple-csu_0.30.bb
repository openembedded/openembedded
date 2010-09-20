DESCRIPTION = "Core iPhone libs"
HOMEPAGE = "http://code.google.com/p/iphone-dev"

INHIBIT_DEFAULT_DEPS = "1"
COMPATIBLE_MACHINE = "(iphone)"
SRCREV="285"
SRC_URI = "svn://iphone-dev.googlecode.com/svn/trunk;proto=http;module=csu"

S = "${WORKDIR}/csu"

inherit autotools
