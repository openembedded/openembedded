require rsyslog.inc
PR = "${INC_PR}.0"

SRC_URI += " file://atomics.patch;patch=1"

SRC_URI[archive.md5sum] = "291882229d50496f42bd63174076dd37"
SRC_URI[archive.sha256sum] = "d9cd21d2fcd45fcae65eb0a51927c40315cca02afdc62478abd950febfcf7228"
