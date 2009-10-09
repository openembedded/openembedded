require lighttpd.inc

PR = "${INC_PR}.1"

SRC_URI += "file://configure.in.patch;patch=1 \
	    file://mod_redirect.c.patch;patch=1 \
	    file://src-server.c.patch;patch=1 \
           "

