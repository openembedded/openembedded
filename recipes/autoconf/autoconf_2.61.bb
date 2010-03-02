require autoconf.inc

PR = "${INC_PR}.1"

SRC_URI += "file://autoreconf-include.patch;patch=1 \
	   file://autoreconf-exclude.patch;patch=1 \
	   file://autoreconf-foreign.patch;patch=1 \
	   file://autoreconf-gnuconfigize.patch;patch=1 \
	   file://autoheader-nonfatal-warnings.patch;patch=1 \
	   file://config-site.patch;patch=1 \
	   file://autoconf-dont-execute-perl.patch;patch=1 \
	   "

SRC_URI_append_virtclass-native = " file://fix_path_xtra.patch;patch=1"
