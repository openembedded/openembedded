include openssl.inc

PR = "r1"

SRC_URI += "file://debian.patch;patch=1 \
	    file://armeb.patch;patch=1"
