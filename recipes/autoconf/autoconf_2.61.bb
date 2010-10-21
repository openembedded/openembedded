require autoconf.inc

LICENSE = "GPLv2+"

PR = "${INC_PR}.1"

SRC_URI += "file://autoreconf-include.patch \
	   file://autoreconf-exclude.patch \
	   file://autoreconf-foreign.patch \
	   file://autoreconf-gnuconfigize.patch \
	   file://autoheader-nonfatal-warnings.patch \
	   file://config-site.patch \
	   file://autoconf-dont-execute-perl.patch \
	   "

SRC_URI_append_virtclass-native = " file://fix_path_xtra.patch"

SRC_URI[autoconf.md5sum] = "36d3fe706ad0950f1be10c46a429efe0"
SRC_URI[autoconf.sha256sum] = "93a2ceab963618b021db153f0c881a2de82455c1dc7422be436fcd5c554085a1"
