require autoconf.inc

PR = "${INC_PR}.0"

DEFAULT_PREFERENCE = "-1"

SRC_URI += "file://autoreconf-exclude.patch;apply=yes \
	    file://autoreconf-foreign.patch;apply=yes \
	    file://autoheader-nonfatal-warnings.patch;apply=yes \
	    file://autoreconf-gnuconfigize.patch;apply=yes \
	    file://config-site.patch;apply=yes"

SRC_URI_append_virtclass-native = " file://fix_path_xtra.patch;apply=yes"

SRC_URI[autoconf.md5sum] = "7565809ed801bb5726da0631ceab3699"
SRC_URI[autoconf.sha256sum] = "264d7c1c0e268bc77fbe0f308e085545535edfe73f33e27c80219cc0c9c71246"
