require autoconf.inc

PR = "${INC_PR}.0"

DEFAULT_PREFERENCE = "-1"

SRC_URI += "file://autoreconf-exclude.patch \
	    file://autoreconf-foreign.patch \
	    file://autoheader-nonfatal-warnings.patch \
	    file://autoreconf-gnuconfigize.patch \
	    file://config-site.patch"

SRC_URI_append_virtclass-native = " file://fix_path_xtra.patch"

SRC_URI[autoconf.md5sum] = "7565809ed801bb5726da0631ceab3699"
SRC_URI[autoconf.sha256sum] = "264d7c1c0e268bc77fbe0f308e085545535edfe73f33e27c80219cc0c9c71246"
