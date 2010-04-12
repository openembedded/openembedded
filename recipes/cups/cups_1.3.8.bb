require cups.inc

SRC_URI += "file://use_echo_only_in_init.patch;patch=1"
PR = "${INC_PR}.1"

DEFAULT_PREFERENCE = "-1"

EXTRA_OECONF += " --disable-gssapi "

SRC_URI[md5sum] = "90ed7449948994ad1b22b0b177ab6ba6"
SRC_URI[sha256sum] = "d488980f84ad0e6044a67859144306980624cafb654eb0cab071b3e46fee6e1d"
