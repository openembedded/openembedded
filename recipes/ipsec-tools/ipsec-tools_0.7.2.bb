PR = "${INC_PR}.0"

require ipsec-tools.inc

SRC_URI[ipsec-tools-0.7.2.md5sum] = "72861f005746ee27984b2ee715ecc629"
SRC_URI[ipsec-tools-0.7.2.sha256sum] = "08722ff6c62de3e042fef337454f03622a79053108d6dcc686c9c854f9f9e031"

EXTRA_OECONF += " --disable-security-context"