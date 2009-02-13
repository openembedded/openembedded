require cups.inc

SRC_URI += "file://use_echo_only_in_init.patch;patch=1"
PR = "r1"

DEFAULT_PREFERENCE = "-1"

EXTRA_OECONF += " --disable-gssapi "
