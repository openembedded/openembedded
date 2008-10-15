require blueprobe.inc

PR = "r4"

SRC_URI += "file://h4000.patch;patch=1 \
            file://uclibc-fix.patch;patch=1 \
	    file://rx3000.patch;patch=1"
