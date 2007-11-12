require pulse.inc

# this is not correct (see below)
SRC_URI += "file://disable-using-glibc-tls.patch;patch=1"

PR = "r0"

# problems w/ pulseaudio 0.9.7 atm:
# 1.) needs libtool 1.2.24 (which miscompiles plugins in OE, hence we can't make it the default yet)
# 2.) doesn't build w/ glibc TLS support (hence patched out)
DEFAULT_PREFERENCE = "-1"

