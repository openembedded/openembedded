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

SRC_URI[autoconf.md5sum] = "36d3fe706ad0950f1be10c46a429efe0"
SRC_URI[autoconf.sha256sum] = "93a2ceab963618b021db153f0c881a2de82455c1dc7422be436fcd5c554085a1"
