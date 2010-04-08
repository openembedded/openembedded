require cups14.inc

SRC_URI += "file://use_echo_only_in_init.patch;patch=1 \
		    file://skip_tools.patch;patch=1 \
		    file://configure.patch;patch=1 \
			"

PR = "r2"

DEFAULT_PREFERENCE = "-1"

EXTRA_OECONF += " --disable-gssapi --disable-largefile --enable-debug --disable-relro "
