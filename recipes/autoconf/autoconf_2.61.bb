require autoconf.inc

PR = "${INC_PR}.1"

SRC_URI += "file://autoreconf-include.patch;apply=yes \
	   file://autoreconf-exclude.patch;apply=yes \
	   file://autoreconf-foreign.patch;apply=yes \
	   file://autoreconf-gnuconfigize.patch;apply=yes \
	   file://autoheader-nonfatal-warnings.patch;apply=yes \
	   file://config-site.patch;apply=yes \
	   file://autoconf-dont-execute-perl.patch;apply=yes \
	   "

SRC_URI_append_virtclass-native = " file://fix_path_xtra.patch;apply=yes"

SRC_URI[autoconf.md5sum] = "36d3fe706ad0950f1be10c46a429efe0"
SRC_URI[autoconf.sha256sum] = "93a2ceab963618b021db153f0c881a2de82455c1dc7422be436fcd5c554085a1"
